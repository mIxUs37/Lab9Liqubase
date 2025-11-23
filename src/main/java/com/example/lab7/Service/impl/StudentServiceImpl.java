package com.example.lab7.Service.impl;

import com.example.lab7.Repository.StudentRepository;
import com.example.lab7.Service.StudentService;
import com.example.lab7.dto.StudentDto;
import com.example.lab7.mapper.StudentMapper;
import com.example.lab7.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (Objects.isNull(student)) return null;
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student entity = studentMapper.toEntity(dto);
        Student saved = studentRepository.save(entity);
        return studentMapper.toDto(saved);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());

        Student updated = studentRepository.save(existing);
        return studentMapper.toDto(updated);
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null) return false;
        studentRepository.delete(existing);
        return true;
    }
}
