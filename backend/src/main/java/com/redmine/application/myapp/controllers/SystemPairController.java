package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.SystemPair;
import com.redmine.application.myapp.repositories.SystemPairRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.100.191:4200/"})
public class SystemPairController {

    private final SystemPairRepository systemPairRepository;

    public SystemPairController(SystemPairRepository systemPairRepository) {
        this.systemPairRepository = systemPairRepository;
    }



    @GetMapping("rest/getsystempairs")
    public List<SystemPair> getSystemPairs() {
        return (List<SystemPair>) systemPairRepository.findAll();

    }

    @PostMapping("rest/savesystempair")
    void addProjecct(@RequestBody SystemPair system_Pair) {
        systemPairRepository.save(system_Pair);
    }

}