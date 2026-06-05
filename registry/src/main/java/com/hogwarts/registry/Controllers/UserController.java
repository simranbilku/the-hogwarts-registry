package com.hogwarts.registry.Controllers;

import com.hogwarts.registry.dtos.CreateUserRequest;
import com.hogwarts.registry.dtos.UserResponse;
import com.hogwarts.registry.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}


