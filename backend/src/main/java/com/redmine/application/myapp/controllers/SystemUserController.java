package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.System_User;
import com.redmine.application.myapp.repositories.SystemUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SystemUserController {

    private final SystemUserRepository systemUserRepository;

    public SystemUserController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }



    @GetMapping("/getallsystemusers")
    public List<System_User> getSystemUsers() {
        return (List<System_User>) systemUserRepository.findAll();

    }

    @PostMapping("/savesystemuser")
    void addSystemUser(@RequestBody System_User system_User) {
        systemUserRepository.save(system_User);
    }

    @PostMapping("/updatesystemuser")
        void AddSystemUsers(@RequestBody System_User[] system_User){
        for(int i=0; i<system_User.length;i++){
            if(!systemUserRepository.existsByLoginAndSystemid(system_User[i].getLogin() , system_User[i].getSystemid())){
                System.out.println(system_User[i]);
                addSystemUser(system_User[i]);
            }
        }
    }


}