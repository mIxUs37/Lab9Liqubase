package com.example.lab7.mapper;

import com.example.lab7.dto.StudentDto;
import com.example.lab7.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {GradeMapper.class}
)
public interface StudentMapper {

    StudentDto toDto(Student student);

    @Mapping(target = "grades", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    Student toEntity(StudentDto dto);
}
