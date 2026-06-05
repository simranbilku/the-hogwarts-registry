package com.hogwarts.registry.DTOs;

public class CourseDTO {

    private Long id;
    private String name;
    private String professorName;

    public Long getId() {
        return id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
