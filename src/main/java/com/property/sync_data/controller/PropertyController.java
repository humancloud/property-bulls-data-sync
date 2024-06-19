package com.property.sync_data.controller;

import com.property.sync_data.service.DataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sync")
public class PropertyController {

    @Autowired
    private DataSyncService dataSyncService;

    @GetMapping
    public String sync() {
        return dataSyncService.fetchAndSaveData();
    }

}
