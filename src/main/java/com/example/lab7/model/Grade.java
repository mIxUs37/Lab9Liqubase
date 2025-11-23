package com.example.lab7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    private LocalDate date;

    // Many Grades -> One Student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Many Grades -> One Subject
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
