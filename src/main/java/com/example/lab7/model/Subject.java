package com.example.lab7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String teacherName;

    // Many Students <-> Many Subjects
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();
}
