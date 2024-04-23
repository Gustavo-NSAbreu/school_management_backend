package com.web_development_class.school_management_backend.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_development_class.school_management_backend.Domain.Entity.Enrollment;
import com.web_development_class.school_management_backend.Service.EnrollmentService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @PostMapping("/{sId}&{cId}")
    public ResponseEntity<Enrollment> enroll(@PathVariable UUID sId, @PathVariable UUID cId) {
        Enrollment enrollment = service.enroll(sId, cId);
        return ResponseEntity.ok().body(enrollment);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> unenroll(@PathVariable UUID id) {
        try {
            service.unenroll(id);
            return ResponseEntity.ok().body("Unenrolled successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
