package com.redmine.application.myapp.controllers;

import com.redmine.application.myapp.entities.RedSystem;
import com.redmine.application.myapp.repositories.RedSystemRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RedSystemController {

    private final RedSystemRepository redSystemRepository;

    public RedSystemController(RedSystemRepository redSystemRepository) {
        this.redSystemRepository = redSystemRepository;
    }


    @GetMapping("/getRedSystems")
    public List<RedSystem> getRedSystems() {
        return (List<RedSystem>) redSystemRepository.findAll();
    }

    @PostMapping("/saveRedSystem")
    void addProjecct(@RequestBody RedSystem redSystem) {
        redSystemRepository.save(redSystem);
    }
}