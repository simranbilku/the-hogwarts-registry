package com.hogwarts.registry.Services;

import com.hogwarts.registry.DTOs.CourseDTO;
import com.hogwarts.registry.DTOs.CreateUserRequest;
import com.hogwarts.registry.DTOs.UserResponse;
import com.hogwarts.registry.DTOs.UserWithCoursesResponse;
import com.hogwarts.registry.models.Course;
import com.hogwarts.registry.models.User;
import com.hogwarts.registry.repos.CourseRepository;
import com.hogwarts.registry.repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

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
        user.setFirstName(newUserRequest.getFirstName());
        user.setLastName(newUserRequest.getLastName());
        user.setAge(newUserRequest.getAge());
        user.setEmail(newUserRequest.getEmail());
        user.setPassword(newUserRequest.getPassword());
        user.setHouse(newUserRequest.getHouse());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    // delete user
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with ID: %d, was not found", id));
        }

        userRepository.deleteById(id);
        logger.info("Deleted User with ID: {}", id);
    }

    // get user by id
    public UserWithCoursesResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return mapToUserWithCourseResponse(user);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail(),
                user.getHouse()
        );
    }

    public UserWithCoursesResponse enrollInCourse(Long userId, List<Long> courseIds){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        for(Long courseId : courseIds){
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new IllegalArgumentException("Course not found"));

            user.getCourses().add(course);

        }

        User savedUser = userRepository.save(user);
        return mapToUserWithCourseResponse(savedUser);

    }

    private UserWithCoursesResponse mapToUserWithCourseResponse(User user){
        List<CourseDTO> courseDTOs = user.getCourses().stream()
                .map(userCourse -> {
                    CourseDTO dto = new CourseDTO();
                    dto.setId(userCourse.getId());
                    dto.setName(userCourse.getName());
                    dto.setProfessorName(userCourse.getProfessorName());
                    return dto;
                })
                .toList();

        return new UserWithCoursesResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                courseDTOs,
                user.getAge(),
                user.getEmail(),
                user.getHouse()
        );
    }
}