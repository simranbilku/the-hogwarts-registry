package com.hogwarts.registry.DTOs;

public class CourseDetail {

    private Long id;
    private String name;
    private String professorName;
    private String description;

    public CourseDetail(Long id, String name, String description, String professorName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.professorName = professorName;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

