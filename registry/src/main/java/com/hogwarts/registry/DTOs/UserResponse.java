package com.hogwarts.registry.dtos;

import com.hogwarts.registry.models.House;

public class UserResponse {

    private Long userId;
    private String username;
    private String email;
    private House house;


    public UserResponse(Long userId, String username, String email, House house) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.house = house;
    }


    public Long getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }


    public House getHouse() {
        return house;
    }
}