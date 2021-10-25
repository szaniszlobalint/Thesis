package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.System_User_Pair;
import com.redmine.application.myapp.repositories.SystemUserPairRepository;
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


    @GetMapping("/systemuserpair")
    public List<System_User_Pair> getSystemUserPairs() {
        return (List<System_User_Pair>) systemUserPairRepository.findAll();

    }

    @PostMapping("/savesystemuserpair")
    void addSystemUserPairs(@RequestBody System_User_Pair system_User_Pair) {
        System.out.println(system_User_Pair);
        systemUserPairRepository.save(system_User_Pair);
    }
}