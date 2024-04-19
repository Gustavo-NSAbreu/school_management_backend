package com.web_development_class.school_management_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web_development_class.school_management_backend.Domain.DTO.UpdateStudentDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;
import com.web_development_class.school_management_backend.Service.StudentService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin("http://localhost:3000")
public class StudentController {
    
    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = service.findAll();
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Student> create(@RequestBody Student newStudent) {
        Student student = service.create(newStudent);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Student> update(@RequestBody UpdateStudentDTO updatedStudent) {
        Student student = service.update(updatedStudent.student(), updatedStudent.studentId());
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> delete(@RequestBody StudentId studentId) {
        try {
            service.delete(studentId);
            return ResponseEntity.ok().body("Student deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
