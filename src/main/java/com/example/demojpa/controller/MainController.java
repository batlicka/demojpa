package com.example.demojpa.controller;

import com.example.demojpa.data.ChildrenRepository;
import com.example.demojpa.data.UserRepository;
import com.example.demojpa.entity.Children;
import com.example.demojpa.entity.Dog;
import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private final UserRepository userRepository;
    private final ChildrenRepository childrenRepository;
    private final UserService userService;

    public MainController(UserRepository userRepository, ChildrenRepository childrenRepository, UserService userService) {
        this.userRepository = userRepository;
        this.childrenRepository = childrenRepository;
        this.userService = userService;
    }

    @RequestMapping("/hello{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/test")
    public String test(){
        return "test response";
    }

//    @GetMapping("/get-all")
//    public List<User> c(){
//        return userRepository.findAll();
//    }

    @GetMapping("/createChild/{name}&{age}")
    public Children createChild(@PathVariable String name, @PathVariable Integer age){
        Children child = new Children(null, name,age);
        return childrenRepository.save(child);
    }

    @GetMapping("/create/{name}")
    @Transactional
    public User create(@PathVariable String name){
        Dog first = new Dog(null, "Žeryk");
        Dog second = new Dog(null, "PEs2");
        List<Dog> listDog= new ArrayList<>();
        listDog.add(first);
        listDog.add(second);
        return userRepository.save(new User(null, name, listDog));

    }

    //?
    @GetMapping("/get-all")
    public List<User> c(){
        return userRepository.findAll();
    }

    @GetMapping("/get-all-fetch")
    public List<User> getAllFetch(){
        return userService.getFetchJoin();
    }

    //?
    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-all-dog")
    public List<String> getAllDogs(){
        return userService.getAllDogNamesByUsersT();
    }

    //?
    @GetMapping("/get-all-dog-err")
    public List<String> getU(){
        List<User> users = userService.getAllUsers();
        return userService.getAllDogNames(users);
    }

    @GetMapping("/get-dogs")
    public List<String> getDogs(){
        return userService.getAllDogNames();
    }
}
