package com.web_development_class.school_management_backend.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.school_management_backend.Domain.DTO.CourseDTO;
import com.web_development_class.school_management_backend.Domain.DTO.EnrolledCourseDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;
import com.web_development_class.school_management_backend.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        List<Student> students = repository.findAll();
        return students;
    }

    public Student findById(StudentId id) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return student;
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Student update(Student updatedStudent, StudentId studentId) {
        Student student = repository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        student.update(updatedStudent);
        return repository.save(student);
    }

    public void delete(StudentId studentId) {
        repository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        repository.deleteById(studentId);
    }

    public List<EnrolledCourseDTO> findEnrolledCourses(UUID studentId) {
        return repository.findEnrolledCourses(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public List<CourseDTO> findNotEnrolledCourses(UUID studentId) {
        return repository.findNotEnrolledCourses(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

}
