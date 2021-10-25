package com.redmine.application.redmineA.controllers;

import com.redmine.application.redmineA.entities.ARedmineUser;
import com.redmine.application.redmineA.repositories.AUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AUserController {

    private final AUserRepository userRepository;

    public AUserController(AUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getallredAusers")
    public List<ARedmineUser> getUsers() {
        //System.out.println(userRepository.findAll());
        return (List<ARedmineUser>) userRepository.findAll();
    }

//    @PostMapping("/saveappuser")
//    void addProjecct(@RequestBody App_User app_user) {
//        appUserRepository.save(app_user);
//    }
}