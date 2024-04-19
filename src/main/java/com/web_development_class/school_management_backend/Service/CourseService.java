package com.web_development_class.school_management_backend.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_development_class.school_management_backend.Domain.Entity.Course;
import com.web_development_class.school_management_backend.Domain.Entity.Student;
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

    public Course create(Course student) {
        return repository.save(student);
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

    public List<Student> findStudents(UUID id) {
        return repository.findStudents(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

}