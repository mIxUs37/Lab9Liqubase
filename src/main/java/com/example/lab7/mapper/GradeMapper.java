package com.example.lab7.mapper;

import com.example.lab7.dto.GradeDto;
import com.example.lab7.model.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "teacherName", source = "subject.teacherName")
    GradeDto toDto(Grade grade);

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "subject", ignore = true)
    Grade toEntity(GradeDto dto);
}
