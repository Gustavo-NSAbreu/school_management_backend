package com.web_development_class.school_management_backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_development_class.school_management_backend.Domain.Entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, UUID> {}
