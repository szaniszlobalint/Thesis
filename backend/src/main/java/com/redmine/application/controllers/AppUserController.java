package com.redmine.application.controllers;

import com.redmine.application.entities.App_User;
import com.redmine.application.repositories.AppUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/test")
    String getMessage() {
        return "Hello Frontends!";
    }

    @GetMapping("/appuser")
    public List<App_User> getStoredUsers() {
        return (List<App_User>) appUserRepository.findAll();

    }

    @PostMapping("/saveappuser")
    void addProjecct(@RequestBody App_User app_user) {
        appUserRepository.save(app_user);
    }
}