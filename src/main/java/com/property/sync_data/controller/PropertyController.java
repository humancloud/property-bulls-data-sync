package com.property.sync_data.controller;

import com.property.sync_data.entity.Property;
import com.property.sync_data.repository.PropertyRepository;
import com.property.sync_data.service.DataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sync")
public class PropertyController {

    private final DataSyncService dataSyncService;

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyController(DataSyncService dataSyncService, PropertyRepository propertyRepository) {
        this.dataSyncService = dataSyncService;
        this.propertyRepository = propertyRepository;
    }

    @GetMapping
    public void sync() {
        dataSyncService.fetchAndSaveData();
    }

    @GetMapping("/fetch/{listingId}")
    public Property getProperty(@PathVariable("listingId") String listingKey) {
        return propertyRepository.findByListingKey(listingKey).get();
    }

}
