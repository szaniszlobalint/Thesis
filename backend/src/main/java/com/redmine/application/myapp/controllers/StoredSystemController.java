package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.StoredSystem;
import com.redmine.application.myapp.repositories.SystemRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StoredSystemController {

    private final SystemRepository systemRepository;

    public StoredSystemController(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }


    @GetMapping("/storedsystem")
    public List<StoredSystem> getStoredSystems() {
        return (List<StoredSystem>) systemRepository.findAll();
    }

    @PostMapping("/savestoredsystem")
    void addProjecct(@RequestBody StoredSystem stored_system) {
        systemRepository.save(stored_system);
    }
}