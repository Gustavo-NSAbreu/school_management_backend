package com.web_development_class.school_management_backend.Domain.DTO;


import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;

public record UpdateStudentDTO(Student student, StudentId studentId) {}