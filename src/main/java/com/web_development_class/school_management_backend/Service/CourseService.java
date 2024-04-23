package com.web_development_class.school_management_backend.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.school_management_backend.Domain.DTO.EnrolledStudentDTO;
import com.web_development_class.school_management_backend.Domain.DTO.StudentDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Course;
import com.web_development_class.school_management_backend.Repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<Course> findAll() {
        List<Course> students = repository.findAll();
        return students;
    }

    public Course findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

    public Course create(Course course) {
        return repository.save(course);
    }

    public Course update(Course updatedCourse) {
        Course course = repository.findById(updatedCourse.getId()).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        course.update(updatedCourse);
        return repository.save(course);
    }

    public void delete(UUID id) {
        repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        repository.deleteById(id);
    }

    public List<EnrolledStudentDTO> findEnrolledStudents(UUID id) {
        return repository.findEnrolledStudents(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

    public List<StudentDTO> findNotEnrolledStudents(UUID id) {
        return repository.findNotEnrolledStudents(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

}