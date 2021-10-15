package com.redmine.application.controllers;

import com.redmine.application.entities.Project;
import com.redmine.application.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/test")
    String getMessage() {
        return "Hello Frontends!";
    }

    @GetMapping("/project")
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();

    }

    @PostMapping("/saveproject")
    void addProjecct(@RequestBody Project project) {
        projectRepository.save(project);
    }
}