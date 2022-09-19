package com.example.demojpa.entity;

import javax.persistence.*;

@Entity
@Table(name="children")
public class Children {
    @Id
    @GeneratedValue(generator = "children_idx")
    @SequenceGenerator(name= "children_idx", sequenceName = "children_idx")
    private Long id;

    @Column(name="jmeno", length = 1000)
    private String name;

    private Integer age;

    public Children() {
    }

    public Children(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

