package com.hogwarts.registry.DTOs;

import com.hogwarts.registry.models.House;

import java.util.List;

public class UserWithCoursesResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private House house;
    private List<CourseDTO> courses;


    public UserWithCoursesResponse(Long userId, String firstName, String lastName, House house, List<CourseDTO> courses) {
        this.userId = userId;
        this.house = house;
        this.courses = courses;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getUserId() {
        return userId;
    }


    public House getHouse() {
        return house;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }
}
