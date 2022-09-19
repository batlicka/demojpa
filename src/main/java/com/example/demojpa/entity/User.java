package com.example.demojpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_idx")
    @SequenceGenerator(name= "user_idx", sequenceName = "user_idx")
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @OneToMany(mappedBy = "owner",  cascade = CascadeType.ALL)
    private List<Dog> dogs;

    public User() {

    }

    public User(Long id, String username, List<Dog> dogs) {
        this.id = id;
        this.username = username;

        for (Dog x : dogs) {
            System.out.println("this: "+this);
            x.setOwner(this);
        }
        this.dogs = dogs;

        //this.dogs = dogs.stream().peek(x->x.setOwner(this)).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}