package com.web_development_class.school_management_backend.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web_development_class.school_management_backend.Domain.DTO.CourseDTO;
import com.web_development_class.school_management_backend.Domain.DTO.EnrolledCourseDTO;
import com.web_development_class.school_management_backend.Domain.DTO.UpdateStudentDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;
import com.web_development_class.school_management_backend.Service.StudentService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = service.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<EnrolledCourseDTO>> findEnrolledStudents(@PathVariable UUID id) {
        List<EnrolledCourseDTO> students = service.findEnrolledCourses(id);
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}/students/not-enrolled")
    public ResponseEntity<List<CourseDTO>> findNotEnrolledStudents(@PathVariable UUID id) {
        List<CourseDTO> students = service.findNotEnrolledCourses(id);
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
