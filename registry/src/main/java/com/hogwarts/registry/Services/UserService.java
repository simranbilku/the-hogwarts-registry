package com.hogwarts.registry.Services;

import com.hogwarts.registry.DTOs.CreateUserRequest;
import com.hogwarts.registry.DTOs.UserResponse;
import com.hogwarts.registry.models.User;
import com.hogwarts.registry.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // get all users
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // create user
    public UserResponse addUser(CreateUserRequest newUserRequest) {

        if (userRepository.existsByEmail(newUserRequest.getEmail())) {
            throw new IllegalArgumentException("This user email is already in use!");
        }

        User user = new User();
        user.setUsername(newUserRequest.getUsername());
        user.setEmail(newUserRequest.getEmail());
        user.setPassword(newUserRequest.getPassword());
        user.setHouse(newUserRequest.getHouse());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    // get user by id
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return mapToResponse(user);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getHouse()
        );
    }
}