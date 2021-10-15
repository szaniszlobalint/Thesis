package com.redmine.application.controllers;

import com.redmine.application.entities.Project;
import com.redmine.application.entities.System_User;
import com.redmine.application.repositories.ProjectRepository;
import com.redmine.application.repositories.SystemUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SystemUserController {

    private final SystemUserRepository systemUserRepository;

    public SystemUserController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @GetMapping("/test")
    String getMessage() {
        return "Hello Frontends!";
    }

    @GetMapping("/systemuser")
    public List<System_User> getSystemUsers() {
        return (List<System_User>) systemUserRepository.findAll();

    }

    @PostMapping("/savesystemuser")
    void addProjecct(@RequestBody System_User system_User) {
        systemUserRepository.save(system_User);
    }
}