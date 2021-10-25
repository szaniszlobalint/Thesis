package com.redmine.application.redmineB.controllers;

import com.redmine.application.redmineB.entities.BRedmineUser;
import com.redmine.application.redmineB.repositories.BUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BUserController {

    private final BUserRepository userRepository;

    public BUserController(BUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getallredBusers")
    public List<BRedmineUser> getUsers() {
        //System.out.println(userRepository.findAll());
        return (List<BRedmineUser>) userRepository.findAll();
    }

//    @PostMapping("/saveappuser")
//    void addProjecct(@RequestBody App_User app_user) {
//        appUserRepository.save(app_user);
//    }
}
