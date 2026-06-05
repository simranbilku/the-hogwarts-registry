package com.hogwarts.registry.Services;

import com.hogwarts.registry.DTOs.CourseDTO;
import com.hogwarts.registry.models.Course;
import com.hogwarts.registry.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

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

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course){
        courseRepository.save(course);
        return course;
    }
}

