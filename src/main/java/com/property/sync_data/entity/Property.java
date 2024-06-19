package com.property.sync_data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "properties")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    @JsonProperty("ListingKey")
    private String listingKey;

    @JsonProperty("ListingId")
    private String listingId;

    @JsonProperty("PropertyType")
    private String propertyType;

    @JsonProperty("PropertySubType")
    private String propertySubType;

    @JsonProperty("StandardStatus")
    private String standardStatus;

    @JsonProperty("ModificationTimestamp")
    private OffsetDateTime modificationTimestamp;

    @JsonProperty("ListPrice")
    private Double listPrice;

    @JsonProperty("LivingArea")
    private Long livingArea;

    @JsonProperty("City")
    private String city;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("UnparsedAddress")
    private String unparsedAddress;

    @JsonProperty("Coordinates")
    @ElementCollection
    @CollectionTable(name = "property_coordinates", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "coordinate")
    private List<Double> coordinates;

    @JsonProperty("Latitude")
    private Double latitude;

    @JsonProperty("Longitude")
    private Double longitude;

    @JsonProperty("YearBuilt")
    private Long yearBuilt;

    @JsonProperty("InternetAddressDisplayYN")
    private Boolean internetAddressDisplayYN;

    @JsonProperty("FeedTypes")
    private String feedTypes;

    @JsonProperty("ListAgentFullName")
    private String listAgentFullName;

    @JsonProperty("ListOfficeName")
    private String listOfficeName;

    @JsonProperty("ListAgentMlsId")
    private String listAgentMlsId;

    @JsonProperty("ListOfficeMlsId")
    private String listOfficeMlsId;

    @JsonProperty("OriginatingSystemName")
    private String originatingSystemName;

    @JsonProperty("PublicRemarks")
    @Column(name = "public_remarks", columnDefinition = "TEXT")
    private String publicRemarks;

    @JsonProperty("Media")
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> media;

}
