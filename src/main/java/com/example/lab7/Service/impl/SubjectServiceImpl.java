package com.example.lab7.Service.impl;

import com.example.lab7.Repository.SubjectRepository;
import com.example.lab7.Service.SubjectService;
import com.example.lab7.dto.SubjectDto;
import com.example.lab7.mapper.SubjectMapper;
import com.example.lab7.model.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public List<SubjectDto> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    @Override
    public SubjectDto getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        if (Objects.isNull(subject)) return null;
        return subjectMapper.toDto(subject);
    }

    @Override
    public SubjectDto createSubject(SubjectDto dto) {
        Subject entity = subjectMapper.toEntity(dto);
        Subject saved = subjectRepository.save(entity);
        return subjectMapper.toDto(saved);
    }

    @Override
    public SubjectDto updateSubject(Long id, SubjectDto dto) {
        Subject existing = subjectRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(dto.getName());
        existing.setTeacherName(dto.getTeacherName());

        Subject updated = subjectRepository.save(existing);
        return subjectMapper.toDto(updated);
    }

    @Override
    public boolean deleteSubject(Long id) {
        Subject existing = subjectRepository.findById(id).orElse(null);
        if (existing == null) return false;
        subjectRepository.delete(existing);
        return true;
    }
}
