package com.hogwarts.registry.Controllers;

import com.hogwarts.registry.DTOs.CourseDTO;
import com.hogwarts.registry.Services.CourseService;
import com.hogwarts.registry.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;
    
    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
}
