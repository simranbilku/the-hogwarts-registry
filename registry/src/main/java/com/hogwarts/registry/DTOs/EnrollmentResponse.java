package com.hogwarts.registry.DTOs;

public class EnrollmentResponse {
    private String message;
    private UserWithCoursesResponse user;

    public EnrollmentResponse(String message, UserWithCoursesResponse user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() { return message; }
    public UserWithCoursesResponse getUser() { return user; }
}
