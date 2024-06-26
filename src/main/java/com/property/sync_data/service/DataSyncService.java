package com.property.sync_data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.sync_data.dto.AccessTokenResponse;
import com.property.sync_data.dto.PropertyResponse;
import com.property.sync_data.entity.Property;
import com.property.sync_data.repository.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DataSyncService {

    @Value("${realtyna.auth_url}")
    private String authUrl;

    @Value("${realtyna.base_url}")
    private String baseUrl;

    @Value("${realtyna.client_id}")
    private String clientId;

    @Value("${realtyna.grant_type}")
    private String grantType;

    @Value("${realtyna.client_secret}")
    private String clientSecret;

    @Value("${realtyna.api_key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final PropertyRepository propertyRepository;


    @Autowired
    public DataSyncService(RestTemplate restTemplate, ObjectMapper objectMapper, PropertyRepository propertyRepository) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.propertyRepository = propertyRepository;
    }

    @Async("taskExecutor")
    public CompletableFuture<String> fetchAccessToken() {
        log.info("Fetching access token");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("grant_type", grantType);
        body.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<AccessTokenResponse> response = restTemplate.exchange(
                authUrl, HttpMethod.POST, requestEntity, AccessTokenResponse.class);

        String accessToken = Objects.requireNonNull(response.getBody()).getAccessToken();
        return CompletableFuture.completedFuture(accessToken);
    }

    @Async("taskExecutor")
    public CompletableFuture<List<Property>> fetchData(String accessToken) {
        log.info("Fetching data with access token: {}", accessToken);
        List<Property> properties = new ArrayList<>();
        fetchAllProperties(baseUrl + "/Property?$top=1&$skip=0", accessToken, properties);
        log.info("Fetched {} properties", properties.size());
        return CompletableFuture.completedFuture(properties);
    }

    @Async("taskExecutor")
    public void fetchAllProperties(String url, String accessToken, List<Property> properties) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("x-api-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);
        try {
            PropertyResponse propertyResponse = objectMapper.readValue(response.getBody(), PropertyResponse.class);

            propertyResponse.getValue().parallelStream().forEach(property -> {
                Optional<Property> existingProperty = propertyRepository.findByListingKey(property.getListingKey());

                if (existingProperty.isPresent()) {
                    if (existingProperty.get().getModificationTimestamp().isBefore(property.getModificationTimestamp())) {
                        property.setListingKey(existingProperty.get().getListingKey());
                        properties.add(property);
                    }
                } else
                    properties.add(property);
            });

            if (!properties.isEmpty()) {
                propertyRepository.saveAll(properties);
            }

            String nextLink = propertyResponse.getOdataNextLink();
//            if (nextLink != null && !nextLink.isEmpty()) {
//                fetchAllProperties(nextLink, accessToken, properties);
//            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchAndSaveData() {
        fetchAccessToken()
                .thenCompose(accessToken -> fetchData(accessToken))
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
        log.info("Data sync job completed at {}", LocalDateTime.now());
    }

}
