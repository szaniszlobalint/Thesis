package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.ProjectPair;
import com.redmine.application.myapp.entities.SystemUserPair;
import com.redmine.application.myapp.repositories.ProjectPairRepository;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.100.191:4200/"})
public class ProjectPairController {

    static final Logger logger = Logger.getLogger(ProjectPairController.class);

    private final ProjectPairRepository projectPairRepository;

    public ProjectPairController(ProjectPairRepository projectPairRepository) {
        this.projectPairRepository = projectPairRepository;
    }


    @GetMapping("rest/getprojectpairs")
    public List<ProjectPair> getProjectPairs() {
        return (List<ProjectPair>) projectPairRepository.findAll();
    }

    @PostMapping("rest/saveprojectpair")
    void addProjecPair(@RequestBody ProjectPair projectPair) {
        projectPairRepository.save(projectPair);
    }

    @PostMapping("rest/deleteprojectpair")
    void deleteProjectPair(@RequestBody SystemUserPair projectPair){
        projectPairRepository.delete(projectPairRepository.findByAidAndBid(projectPair.getAId(),projectPair.getBId()));
    }
}