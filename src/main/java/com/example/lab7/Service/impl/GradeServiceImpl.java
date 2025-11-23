package com.example.lab7.Service.impl;

import com.example.lab7.Repository.GradeRepository;
import com.example.lab7.Repository.StudentRepository;
import com.example.lab7.Repository.SubjectRepository;
import com.example.lab7.Service.GradeService;
import com.example.lab7.dto.GradeDto;
import com.example.lab7.mapper.GradeMapper;
import com.example.lab7.model.Grade;
import com.example.lab7.model.Student;
import com.example.lab7.model.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GradeMapper gradeMapper;

    @Override
    public List<GradeDto> getAllGrades() {
        return gradeRepository.findAll()
                .stream()
                .map(gradeMapper::toDto)
                .toList();
    }

    @Override
    public GradeDto getGradeById(Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (Objects.isNull(grade)) return null;
        return gradeMapper.toDto(grade);
    }

    @Override
    public GradeDto createGrade(GradeDto dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        Subject subject = subjectRepository.findById(dto.getSubjectId()).orElse(null);

        if (student == null || subject == null) {
            return null;
        }

        Grade grade = gradeMapper.toEntity(dto);
        grade.setStudent(student);
        grade.setSubject(subject);

        if (!student.getSubjects().contains(subject)) {
            student.getSubjects().add(subject);
        }
        if (!subject.getStudents().contains(student)) {
            subject.getStudents().add(student);
        }

        Grade saved = gradeRepository.save(grade);
        return gradeMapper.toDto(saved);
    }

    @Override
    public GradeDto updateGrade(Long id, GradeDto dto) {
        Grade existing = gradeRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setValue(dto.getValue());
        existing.setDate(dto.getDate());

        Grade updated = gradeRepository.save(existing);
        return gradeMapper.toDto(updated);
    }

    @Override
    public boolean deleteGrade(Long id) {
        Grade existing = gradeRepository.findById(id).orElse(null);
        if (existing == null) return false;

        gradeRepository.delete(existing);
        return true;
    }
}
