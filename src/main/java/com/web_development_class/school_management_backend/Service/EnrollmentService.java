package com.web_development_class.school_management_backend.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.school_management_backend.Domain.Entity.Enrollment;
import com.web_development_class.school_management_backend.Repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepository repository;

    public Enrollment enroll(UUID sId, UUID cId) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(sId);
        enrollment.setCourseId(cId);
        return repository.save(enrollment);
    }
    public void unenroll(UUID id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Enrollment not found"));
        repository.deleteById(id);
    }
}
