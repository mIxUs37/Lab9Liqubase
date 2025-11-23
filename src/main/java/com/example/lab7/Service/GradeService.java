package com.example.lab7.Service;

import com.example.lab7.dto.GradeDto;

import java.util.List;

public interface GradeService {

    List<GradeDto> getAllGrades();
    GradeDto getGradeById(Long id);
    GradeDto createGrade(GradeDto dto);
    GradeDto updateGrade(Long id, GradeDto dto);
    boolean deleteGrade(Long id);
}
