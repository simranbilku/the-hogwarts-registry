package com.hogwarts.registry.DTOs;

import com.hogwarts.registry.models.House;

import java.util.List;

public class UserWithCoursesResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private List<CourseDTO> courses;


    public UserWithCoursesResponse(Long userId, String firstName, String lastName, List<CourseDTO> courses) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
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


    public List<CourseDTO> getCourses() {
        return courses;
    }
}
