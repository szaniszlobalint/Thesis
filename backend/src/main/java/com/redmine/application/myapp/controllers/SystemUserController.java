package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.SystemUser;
import com.redmine.application.myapp.repositories.SystemUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.100.191:4200/"})
public class SystemUserController {

    private final SystemUserRepository systemUserRepository;

    public SystemUserController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }



    @GetMapping("rest/getallsystemusers")
    public List<SystemUser> getSystemUsers() {
        return (List<SystemUser>) systemUserRepository.findAll();

    }

    @PostMapping("rest/savesystemuser")
    void addSystemUser(@RequestBody SystemUser system_User) {
        systemUserRepository.save(system_User);
    }

    @PostMapping("rest/updatesystemuser")
    void addSystemUsers(@RequestBody SystemUser[] systemUsers){
        for (SystemUser systemUser : systemUsers) {
            if (!systemUserRepository.existsByLoginAndSystemid(systemUser.getLogin(), systemUser.getSystemid())) {
                addSystemUser(systemUser);
            }
        }
    }


}