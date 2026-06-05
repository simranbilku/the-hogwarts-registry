package com.hogwarts.registry.repos;
import com.hogwarts.registry.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
