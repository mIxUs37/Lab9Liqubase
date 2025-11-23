package com.example.lab7.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private int age;

    private List<GradeDto> grades;
}
