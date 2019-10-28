package com.example.cache.controller;

import com.example.cache.model.Student;
import com.example.cache.model.StudentProfile;
import com.example.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/student")
public class Controller {

    @Autowired
    private CacheService service;

    @PostMapping(path="/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentProfile studentProfile(@RequestBody Student student) throws InterruptedException {
        return service.retrieve(student);
    }
    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
    public String addProfile(@RequestBody StudentProfile profile) throws InterruptedException {
        service.create(new Student(profile.getId(),profile.getLastname()), profile);
        return "Done";
    }
    @DeleteMapping(path="/delete",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
    public String deleteProfile(@RequestBody Student student) throws InterruptedException {
        service.delete(student);
        return "Done";
    }
}
