package com.redmine.application.controllers;

import com.redmine.application.entities.Project;
import com.redmine.application.entities.System_Pair;
import com.redmine.application.repositories.ProjectRepository;
import com.redmine.application.repositories.SystemPairRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
public class SystemPairController {

    private final SystemPairRepository systemPairRepository;

    public SystemPairController(SystemPairRepository systemPairRepository) {
        this.systemPairRepository = systemPairRepository;
    }



    @GetMapping("/systempair")
    public List<System_Pair> getSystemPairs() {
        return (List<System_Pair>) systemPairRepository.findAll();

    }

    @PostMapping("/savesystempair")
    void addProjecct(@RequestBody System_Pair system_Pair) {
        systemPairRepository.save(system_Pair);
    }
}