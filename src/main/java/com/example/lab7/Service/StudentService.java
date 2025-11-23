package com.example.lab7.Service;

import com.example.lab7.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createStudent(StudentDto dto);
    StudentDto updateStudent(Long id, StudentDto dto);
    boolean deleteStudent(Long id);
}
