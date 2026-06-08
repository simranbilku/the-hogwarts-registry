package com.hogwarts.registry.DTOs;

import com.hogwarts.registry.models.House;

import java.util.List;

public class UserWithCoursesResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private List<CourseDTO> courses;
    private Integer age;
    private String email;
    private House house;


    public UserWithCoursesResponse(
            Long userId,
            String firstName,
            String lastName,
            List<CourseDTO> courses,
            Integer age,
            String email,
            House house
    ) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
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

    public Long getUserId() {
        return userId;
    }


    public List<CourseDTO> getCourses() {
        return courses;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public House getHouse() {
        return house;
    }
}
