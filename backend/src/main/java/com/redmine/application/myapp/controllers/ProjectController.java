package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.Project;
import com.redmine.application.myapp.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.100.191:4200/"})
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("rest/getallprojects")
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();

    }

    @PostMapping("rest/saveproject")
    void addProject(@RequestBody Project project) {
        projectRepository.save(project);
    }
}