package com.web_development_class.school_management_backend.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_development_class.school_management_backend.Domain.Entity.StudentCourse;
import com.web_development_class.school_management_backend.Service.StudentCourseService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/enrollments")
@CrossOrigin("http://localhost:3000")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @PostMapping
    public ResponseEntity<String> enroll(@RequestBody StudentCourse enrollment) {
        service.enroll(enrollment);
        return ResponseEntity.ok().body("Enrolled successfully!");
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> unenroll(@RequestBody UUID id) {
        try {
            service.unenroll(id);
            return ResponseEntity.ok().body("Unenrolled successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
