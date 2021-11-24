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
        systemUserPairRepository.delete(systemUserPairRepository.findByAidAndBid(systemUserPair.getAId(),systemUserPair.getBId()));
    }

    @PostMapping("/checksystemuserpairs")
    SystemUserPair checkPairs(@RequestBody SystemUserPair system_user_pair){
        if(systemUserPairRepository.existsByAid(system_user_pair.getAId())){
            System.out.println(systemUserPairRepository.findByAid(system_user_pair.getAId()).getBId());
            return systemUserPairRepository.findByAid(system_user_pair.getAId());
        }else if(systemUserPairRepository.existsByBid(system_user_pair.getBId())){
            System.out.println(systemUserPairRepository.findByBid(system_user_pair.getBId()).getAId());
            return systemUserPairRepository.findByBid(system_user_pair.getBId());
        }
        return null;
    }
}