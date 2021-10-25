package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.Project;
import com.redmine.application.myapp.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/project")
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();

    }

    @PostMapping("/saveproject")
    void addProject(@RequestBody Project project) {
        projectRepository.save(project);
    }
}