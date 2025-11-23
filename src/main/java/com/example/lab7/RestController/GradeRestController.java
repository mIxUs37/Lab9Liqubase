package com.example.lab7.RestController;

import com.example.lab7.Service.GradeService;
import com.example.lab7.dto.GradeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grades")
public class GradeRestController {

    private final GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<GradeDto>> getAll() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> getById(@PathVariable Long id) {
        GradeDto dto = gradeService.getGradeById(id);
        return (dto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<GradeDto> create(@RequestBody GradeDto dto) {
        GradeDto created = gradeService.createGrade(dto);
        return (created == null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeDto> update(@PathVariable Long id, @RequestBody GradeDto dto) {
        GradeDto updated = gradeService.updateGrade(id, dto);
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = gradeService.deleteGrade(id);
        return deleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
