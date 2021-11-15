package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.SystemUserPair;
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
    public List<SystemUserPair> getSystemUserPairs() {
        return (List<SystemUserPair>) systemUserPairRepository.findAll();

    }

    @PostMapping("/savesystemuserpair")
    void addSystemUserPairs(@RequestBody SystemUserPair system_User_Pair) {
        systemUserPairRepository.save(system_User_Pair);
    }

    @PostMapping("/deletesystemuserpair")
    void deleteSystemUserPair(@RequestBody SystemUserPair systemUserPair){
        systemUserPairRepository.delete(systemUserPairRepository.findByAuseridAndBuserid(systemUserPair.getAuserid(),systemUserPair.getBuserid()));
    }

    @PostMapping("/checksystemuserpairs")
    SystemUserPair checkPairs(@RequestBody SystemUserPair system_user_pair){
        if(systemUserPairRepository.existsByAuserid(system_user_pair.getAuserid())){
            System.out.println(systemUserPairRepository.findByAuserid(system_user_pair.getAuserid()).getBuserid());
            return systemUserPairRepository.findByAuserid(system_user_pair.getAuserid());
        }else if(systemUserPairRepository.existsByBuserid(system_user_pair.getBuserid())){
            System.out.println(systemUserPairRepository.findByBuserid(system_user_pair.getBuserid()).getAuserid());
            return systemUserPairRepository.findByBuserid(system_user_pair.getBuserid());
        }
        return null;
    }
}