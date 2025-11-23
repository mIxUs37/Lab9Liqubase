package com.example.lab7.Controller;

import com.example.lab7.Service.StudentService;
import com.example.lab7.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/add")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new StudentDto());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudentSubmit(@ModelAttribute("student") StudentDto dto) {
        studentService.createStudent(dto);
        return "redirect:/";
    }
}
