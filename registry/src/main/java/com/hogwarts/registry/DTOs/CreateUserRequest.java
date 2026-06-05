package com.hogwarts.registry.dtos;

import com.hogwarts.registry.models.House;

public class CreateUserRequest {

    private String username;
    private String email;
    private String password;
    private House house;


    public CreateUserRequest() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}