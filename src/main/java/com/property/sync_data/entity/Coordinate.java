package com.property.sync_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Coordinate {

    @Column(name = "lng")
    private Double longitude;

    @Column(name = "ltd")
    private Double latitude;

}
