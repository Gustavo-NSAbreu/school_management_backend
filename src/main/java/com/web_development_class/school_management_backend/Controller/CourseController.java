package com.web_development_class.school_management_backend.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_development_class.school_management_backend.Domain.DTO.EnrolledStudentDTO;
import com.web_development_class.school_management_backend.Domain.DTO.StudentDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Course;
import com.web_development_class.school_management_backend.Service.CourseService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "*")
public class CourseController {
        
    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = service.findAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable UUID id) {
        Course course = service.findById(id);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<EnrolledStudentDTO>> findEnrolledStudents(@PathVariable UUID id) {
        List<EnrolledStudentDTO> students = service.findEnrolledStudents(id);
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}/students/not-enrolled")
    public ResponseEntity<List<StudentDTO>> findNotEnrolledStudents(@PathVariable UUID id) {
        List<StudentDTO> students = service.findNotEnrolledStudents(id);
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Course> create(@RequestBody Course newCourse) {
        Course course = service.create(newCourse);
        return ResponseEntity.ok().body(course);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Course> update(@RequestBody Course updatedCourse) {
        Course course = service.update(updatedCourse);
        return ResponseEntity.ok().body(course);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body("Course deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}