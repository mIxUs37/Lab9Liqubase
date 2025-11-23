package com.example.lab7.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GradeDto {

    private Long id;
    private int value;
    private LocalDate date;

    private Long studentId;
    private Long subjectId;

    private String subjectName;
    private String teacherName;
}
