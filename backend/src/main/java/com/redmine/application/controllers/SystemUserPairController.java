package com.redmine.application.controllers;

import com.redmine.application.entities.Project;
import com.redmine.application.entities.System_User_Pair;
import com.redmine.application.repositories.ProjectRepository;
import com.redmine.application.repositories.SystemUserPairRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SystemUserPairController {

    private final SystemUserPairRepository systemUserPairRepository;

    public SystemUserPairController(SystemUserPairRepository systemUserPairRepository) {
        this.systemUserPairRepository = systemUserPairRepository;
    }

    @GetMapping("/test")
    String getMessage() {
        return "Hello Frontends!";
    }

    @GetMapping("/systemuserpair")
    public List<System_User_Pair> getSystemUserPairs() {
        return (List<System_User_Pair>) systemUserPairRepository.findAll();

    }

    @PostMapping("/savesystemuserpair")
    void addProjecct(@RequestBody System_User_Pair system_User_Pair) {
        systemUserPairRepository.save(system_User_Pair);
    }
}