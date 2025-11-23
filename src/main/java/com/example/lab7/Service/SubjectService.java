package com.example.lab7.Service;

import com.example.lab7.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    List<SubjectDto> getAllSubjects();
    SubjectDto getSubjectById(Long id);
    SubjectDto createSubject(SubjectDto dto);
    SubjectDto updateSubject(Long id, SubjectDto dto);
    boolean deleteSubject(Long id);
}
