package com.example.demojpa.controller;

import com.example.demojpa.data.UserRepository;
import com.example.demojpa.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/hello{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/insertUser")
    @Transactional
    public User insert(){
        User newUser = new User("pepa", "pepa@test.cz");
        return (User) userRepository.save(newUser);
    }
}
