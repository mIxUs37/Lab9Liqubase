package com.example.lab7.Controller;

import com.example.lab7.Service.GradeService;
import com.example.lab7.Service.StudentService;
import com.example.lab7.Service.SubjectService;
import com.example.lab7.dto.GradeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    @GetMapping("/add")
    public String addGradePage(Model model) {
        model.addAttribute("grade", new GradeDto());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "add-grade";
    }

    @PostMapping("/add")
    public String addGradeSubmit(@ModelAttribute("grade") GradeDto gradeDto) {
        gradeDto.setId(null);
        gradeService.createGrade(gradeDto);
        return "redirect:/";
    }
}
