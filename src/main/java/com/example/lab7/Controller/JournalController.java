package com.example.lab7.Controller;

import com.example.lab7.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JournalController {

    private final StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index"; // templates/index.html
    }
}
