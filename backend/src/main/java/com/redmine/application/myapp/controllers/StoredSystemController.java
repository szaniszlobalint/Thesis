package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.Stored_System;
import com.redmine.application.myapp.repositories.SystemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoredSystemController {

    private final SystemRepository systemRepository;

    public StoredSystemController(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }


    @GetMapping("/storedsystem")
    public List<Stored_System> getStoredSystems() {
        return (List<Stored_System>) systemRepository.findAll();
    }

    @PostMapping("/savestoredsystem")
    void addProjecct(@RequestBody Stored_System stored_system) {
        systemRepository.save(stored_system);
    }
}