package com.hogwarts.registry.Services;

import com.hogwarts.registry.DTOs.CourseDTO;
import com.hogwarts.registry.DTOs.CourseDetail;
import com.hogwarts.registry.models.Course;
import com.hogwarts.registry.repos.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(course -> {
                    CourseDTO dto = new CourseDTO();

                    dto.setId(course.getId());
                    dto.setName(course.getName());
                    dto.setProfessorName(course.getProfessorName());

                    return dto;
                })
                .toList();
    }

    public CourseDetail getCourseById(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course does not exist"));

        return new CourseDetail(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getProfessorName()
        );
    }

}

