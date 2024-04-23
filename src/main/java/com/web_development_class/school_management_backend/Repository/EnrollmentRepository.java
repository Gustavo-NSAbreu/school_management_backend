package com.web_development_class.school_management_backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_development_class.school_management_backend.Domain.Entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {}
