package com.property.sync_data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "media")
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_num")
    @JsonProperty("Order")
    private Integer order;

    @JsonProperty("MediaKey")
    private String mediaKey;

    @JsonProperty("MediaURL")
    private String mediaURL;

    @JsonProperty("MediaSize")
    private Integer mediaSize;

    @JsonProperty("ResourceRecordKey")
    private String resourceRecordKey;

    @JsonProperty("ResourceName")
    private String resourceName;

    @JsonProperty("MediaType")
    private String mediaType;

    @JsonProperty("ClassName")
    private String className;

    @JsonProperty("Thumbnail")
    private String thumbnail;

    @JsonProperty("MediaCategory")
    private String mediaCategory;

    @JsonProperty("MediaObjectID")
    private String mediaObjectID;

    @ManyToOne
    @JoinColumn(name = "property_listing_key")
    private Property property;
}
