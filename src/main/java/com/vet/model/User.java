package com.vet.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 45)
    private String email;

    @Column(length = 15,nullable = false)
    private String password;

    @Column(length = 14,nullable = false)
    private String phoneNumber;

    @Column(length = 45,nullable = false)
    private String firstName;

    @Column(length = 45,nullable = false)
    private String lastName;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn( name = "user_id", referencedColumnName = "id")
//    List<Animal> animalList = new ArrayList<>();
//
//    public List<Animal> getAnimalList() {
//        return animalList;
//    }
//
//    public void setAnimalList(List<Animal> animalList) {
//        this.animalList = animalList;
//    }

//    public User() {
//    }
//
//    public User(Integer id) {
//        this.id = id;
//    }
//
//    public User(String firstName) {
//        this.firstName = firstName;
//    }



//    public User(String password, String phoneNumber, String firstName, String lastName) {
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public User(Integer id, String email, String password, String phoneNumber, String firstName, String lastName) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

//    @Override
//    public String toString(){
//        return "User{"+
//                "id="+id+
//                ", email='" +email+'\''+
//                ", password='" +password+'\''+
//                ", firstName='" +firstName+'\''+
//                ", lastName='" +lastName+'\''+
//                '}';
//    }
}
