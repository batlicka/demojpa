package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="dog")
public class Dog {
    @Id
    @GeneratedValue(generator = "dog_idx")
    @SequenceGenerator(name= "dog_idx", sequenceName = "dog_idx")
    private Long id;

    private String name;

    @ManyToOne()
    @JsonIgnore //do not parse to JSON
    private User owner;

    public Dog() {
    }

    public Dog(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
