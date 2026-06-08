package com.hogwarts.registry.DTOs;

import com.hogwarts.registry.models.House;

public class UserResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private House house;

    public UserResponse(Long userId, String firstName, String lastName, Integer age, String email, House house) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.house = house;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public House getHouse() {
        return house;
    }
}