package com.property.sync_data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.sync_data.dto.AccessTokenResponse;
import com.property.sync_data.dto.PropertyResponse;
import com.property.sync_data.entity.Property;
import com.property.sync_data.repository.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DataSyncService {

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
        String url = "https://realtyfeed-sso.auth.us-east-1.amazoncognito.com/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", "1t0utmqe41ksnvstdqbq6ucvkl");
        body.add("grant_type", "client_credentials");
        body.add("client_secret", "144d23brl9a5srbfqjrgb3niuhu8l0k10qbdahmf9ltotp1p2h20");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<AccessTokenResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, AccessTokenResponse.class);

        String accessToken = Objects.requireNonNull(response.getBody()).getAccessToken();
        log.info("Fetched access token: {}", accessToken);
        return CompletableFuture.completedFuture(accessToken);
    }

    @Async("taskExecutor")
    public CompletableFuture<List<Property>> fetchData(String accessToken) {
        log.info("Fetching data with access token: {}", accessToken);
        String url = "https://api.realtyfeed.com/reso/odata/Property?$top=1000&$skip=0";
        List<Property> properties = new ArrayList<>();
        fetchAllProperties(url, accessToken, properties);
        log.info("Fetched {} properties", properties.size());
        return CompletableFuture.completedFuture(properties);
    }

    @Async("taskExecutor")
    public void fetchAllProperties(String url, String accessToken, List<Property> properties) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("x-api-key", "7OQ1wWSLot6izTWlpPVTe6PHtAzkwJrC1IMfzjPK");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);
        try {
            PropertyResponse propertyResponse = objectMapper.readValue(response.getBody(), PropertyResponse.class);

            String nextLink = propertyResponse.getOdataNextLink();
            if (nextLink != null && !nextLink.isEmpty()) {
                fetchAllProperties(nextLink, accessToken, properties);
            }

            properties.addAll(propertyResponse.getValue());
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Async("taskExecutor")
    public CompletableFuture<Void> saveData(List<Property> properties) {
        propertyRepository.saveAll(properties);
        return CompletableFuture.completedFuture(null);
    }

    public String fetchAndSaveData() {
        fetchAccessToken()
                .thenCompose(accessToken -> fetchData(accessToken))
                .thenCompose(properties -> saveData(properties))
                .exceptionally(ex -> {
                    // Handle exceptions here
                    ex.printStackTrace();
                    return null;
                });

        return "Data fetching and saving started.";
    }

}
