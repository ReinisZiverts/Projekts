package com.tech.techrequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @Autowired
    private TechRepository techRepository;

    @PostMapping("/add")
    public String addTech(@RequestParam String type, @RequestParam String param){
        Tech tech = new Tech();
        tech.setType(type);
        tech.setParam(param);
        tech.setTime(LocalDateTime.now());
        techRepository.save(tech);
        return "Added new Entry";
    }

    @GetMapping("/list")
    public Iterable<Tech> getTech(){
        return techRepository.findAll();
    }


}
