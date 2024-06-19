package com.property.sync_data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.property.sync_data.entity.Property;
import lombok.Data;

import java.util.List;

@Data
public class PropertyResponse {

    private boolean success;

    private String error;

    @JsonProperty("@odata.count")
    private int odataCount;

    @JsonProperty("page_size")
    private int pageSize;

    @JsonProperty("page_count")
    private int pageCount;

    @JsonProperty("value")
    private List<Property> value;

    @JsonProperty("@odata.nextLink")
    private String odataNextLink;

}
