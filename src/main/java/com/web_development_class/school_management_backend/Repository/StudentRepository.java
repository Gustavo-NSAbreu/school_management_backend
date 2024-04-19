package com.web_development_class.school_management_backend.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.Entity.Course;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;

public interface StudentRepository extends JpaRepository<Student, StudentId>{

    @Query("""
        SELECT
            c.id,
            c.name
        FROM student s
        JOIN student_course sc ON s.id = sc.student_id
        LEFT JOIN course c ON sc.course_id = c.id
        WHERE s.id = :student_id
    """)
    public Optional<List<Course>> findCourses(@Param("student_id")UUID student_id);

}
