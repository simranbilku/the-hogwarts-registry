package com.hogwarts.registry.DTOs;

import com.hogwarts.registry.models.House;

import java.util.List;

public class UserWithCoursesResponse {
    private Long userId;
    private String username;
    private String email;
    private House house;
    private List<CourseDTO> courses;


    public UserWithCoursesResponse(Long userId, String username, String email, House house, List<CourseDTO> courses) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.house = house;
        this.courses = courses;
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

    public List<CourseDTO> getCourses() {
        return courses;
    }
}
