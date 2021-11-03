package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.Project_Pair;
import com.redmine.application.myapp.repositories.ProjectPairRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectPairController {

    private final ProjectPairRepository projectPairRepository;

    public ProjectPairController(ProjectPairRepository projectPairRepository) {
        this.projectPairRepository = projectPairRepository;
    }


    @GetMapping("/projectpair")
    public List<Project_Pair> getProjectPairs() {
        return (List<Project_Pair>) projectPairRepository.findAll();

    }

    @PostMapping("/saveprojectpair")
    void addProjecPair(@RequestBody Project_Pair projectPair) {
        projectPairRepository.save(projectPair);
    }
}