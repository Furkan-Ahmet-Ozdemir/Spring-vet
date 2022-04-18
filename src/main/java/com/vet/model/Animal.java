package com.vet.model;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 25)
    private String name;

    @Column(nullable = false,length = 25)
    private String kind;

    @Column(nullable = false,length = 6)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    public Animal() {

    }

    public Animal(Integer id, String name, String kind, String gender, Integer age, String description, User user) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser(){
        return  user;
    }

    public void setUser(User user){
        this.user = user;

    }

}
