package com.example.demo_api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_db")
public class User {

    private String name;
    private String surname;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public User() {
    }

    public User(String name, String surname, String username, String password, int id) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
