package com.hogwarts.registry.Services;

import com.hogwarts.registry.DTOs.CourseDTO;
import com.hogwarts.registry.DTOs.CreateUserRequest;
import com.hogwarts.registry.DTOs.UserResponse;
import com.hogwarts.registry.DTOs.UserWithCoursesResponse;
import com.hogwarts.registry.models.Course;
import com.hogwarts.registry.models.User;
import com.hogwarts.registry.repos.CourseRepository;
import com.hogwarts.registry.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public UserService(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
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

    public UserWithCoursesResponse enrollInCourse(Long userId, Long courseId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));


        user.getCourses().add(course);

        System.out.println("Courses after add: " + user.getCourses());

        User savedUser = userRepository.save(user);
        System.out.println("Courses after save: " + savedUser.getCourses());

        List<CourseDTO> courseDTOs = savedUser.getCourses().stream()
                .map(userCourse -> {
                    CourseDTO dto = new CourseDTO();
                    dto.setId(userCourse.getId());
                    dto.setName(userCourse.getName());
                    dto.setProfessorName(userCourse.getProfessorName());
                    return dto;
                })
                .toList();

        System.out.println("CourseDTOs: " + courseDTOs);

        return new UserWithCoursesResponse(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getHouse(),
                courseDTOs
        );
    }
}