package com.example.demojpa.service;

import com.example.demojpa.data.UserRepository;
import com.example.demojpa.entity.Dog;
import com.example.demojpa.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<String> getAllDogNamesByUsersT(){
        List<User> usersList = userRepository.findAll();
        return getAllDogNames(usersList);
    }

    @Transactional
    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Transactional
    public List<String> getAllDogNames() {
        List<User> userList= getAllUsers();
        return getAllDogNames(userList);
    }

    @Transactional
    public List<String> getAllDogNames(List<User> users){
        return users.stream().flatMap(x->x.getDogs().stream()).map(Dog::getName).collect(Collectors.toList());
    }

//    public  List<User> getFetchJoin() {
//        return em.createQuery("SELECT u FROM User u JOIN FETCH u.dogs",User.class).getResultList();
//    }
}
