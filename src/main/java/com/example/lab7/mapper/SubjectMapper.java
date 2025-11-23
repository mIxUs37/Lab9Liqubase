package com.example.lab7.mapper;

import com.example.lab7.dto.SubjectDto;
import com.example.lab7.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDto toDto(Subject subject);

    Subject toEntity(SubjectDto dto);
}
