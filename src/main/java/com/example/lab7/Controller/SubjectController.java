package com.example.lab7.Controller;

import com.example.lab7.Service.SubjectService;
import com.example.lab7.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/add")
    public String addSubjectPage(Model model) {
        model.addAttribute("subject", new SubjectDto());
        return "add-subject";
    }

    @PostMapping("/add")
    public String addSubjectSubmit(@ModelAttribute("subject") SubjectDto dto) {
        subjectService.createSubject(dto);
        return "redirect:/";
    }
}
