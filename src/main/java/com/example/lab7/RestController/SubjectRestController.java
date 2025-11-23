package com.example.lab7.RestController;

import com.example.lab7.Service.SubjectService;
import com.example.lab7.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subjects")
public class SubjectRestController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAll() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getById(@PathVariable Long id) {
        SubjectDto dto = subjectService.getSubjectById(id);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto dto) {
        return ResponseEntity.ok(subjectService.createSubject(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable Long id, @RequestBody SubjectDto dto) {
        SubjectDto updated = subjectService.updateSubject(id, dto);
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = subjectService.deleteSubject(id);
        return deleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
