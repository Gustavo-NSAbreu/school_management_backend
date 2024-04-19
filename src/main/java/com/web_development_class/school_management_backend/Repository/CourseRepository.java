package com.web_development_class.school_management_backend.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web_development_class.school_management_backend.Domain.Entity.Course;
import com.web_development_class.school_management_backend.Domain.Entity.Student;

public interface CourseRepository extends JpaRepository<Course, UUID>{

  @Query("""
    SELECT
      s.id, 
      s.name,
      s.registration
    FROM course c
    JOIN student_course sc ON c.id = sc.course_id
    LEFT JOIN student s ON sc.student_id = s.id
    WHERE c.id = :id
  """)
  Optional<List<Student>> findStudents(@Param("id")UUID id);
}