package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.AppUser;
import com.redmine.application.myapp.repositories.AppUserRepository;
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
    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser user) {
        try{
            if(appUserRepository.findByUsername(user.getUsername())==null){
                throw new IllegalArgumentException("wrong username!");
            }else{
                return appUserRepository.findByUsername(user.getUsername());
            }
        }catch (IllegalArgumentException e){
            System.out.println("Something went wrong!");
            return null;
        }

    }

    @GetMapping("/getallusers")
    public List<AppUser> getAppUsers() {
        return (List<AppUser>) appUserRepository.findAll();
    }

    @PostMapping("/saveappuser")
    void addProjecct(@RequestBody AppUser app_user) {
        appUserRepository.save(app_user);
    }
}