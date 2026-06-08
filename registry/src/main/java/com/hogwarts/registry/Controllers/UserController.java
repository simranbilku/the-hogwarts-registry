package com.hogwarts.registry.Controllers;

import com.hogwarts.registry.DTOs.CreateUserRequest;
import com.hogwarts.registry.DTOs.EnrollmentResponse;
import com.hogwarts.registry.DTOs.UserResponse;
import com.hogwarts.registry.DTOs.UserWithCoursesResponse;
import com.hogwarts.registry.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // get all users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // create new user
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest newUser) {

        UserResponse userResponse = userService.addUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {

        UserResponse user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/enroll/{courseId}")
    public ResponseEntity<EnrollmentResponse> EnrollInCourse(
            @PathVariable Long userId, @PathVariable Long courseId
    ){
        UserWithCoursesResponse enrolledUser = userService.enrollInCourse(userId, courseId);
        EnrollmentResponse response = new EnrollmentResponse("Successfully enrolled", enrolledUser);
        return ResponseEntity.ok(response);
    }
}


