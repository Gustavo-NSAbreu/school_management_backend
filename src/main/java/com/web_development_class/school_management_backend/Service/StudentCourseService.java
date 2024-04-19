package com.web_development_class.school_management_backend.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.school_management_backend.Domain.Entity.StudentCourse;
import com.web_development_class.school_management_backend.Repository.StudentCourseRepository;

@Service
public class StudentCourseService {
    
    @Autowired
    private StudentCourseRepository repository;

    public void enroll(StudentCourse enrollment) {
        repository.save(enrollment);
    }
    public void unenroll(UUID id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Enrollment not found"));
        repository.deleteById(id);
    }
}
