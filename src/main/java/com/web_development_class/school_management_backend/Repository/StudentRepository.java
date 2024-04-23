package com.web_development_class.school_management_backend.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web_development_class.school_management_backend.Domain.Entity.Student;
import com.web_development_class.school_management_backend.Domain.DTO.CourseDTO;
import com.web_development_class.school_management_backend.Domain.DTO.EnrolledCourseDTO;
import com.web_development_class.school_management_backend.Domain.Entity.StudentId;

public interface StudentRepository extends JpaRepository<Student, StudentId>{

    @Query("""
        SELECT new com.web_development_class.school_management_backend.Domain.DTO.EnrolledCourseDTO(sc.id, c.id, c.name, c.description)
        FROM course c
        JOIN student_course sc ON c.id = sc.courseId WHERE sc.studentId = :student_id
      """)
    public Optional<List<EnrolledCourseDTO>> findEnrolledCourses(@Param("student_id")UUID student_id);

    @Query("""
        SELECT new com.web_development_class.school_management_backend.Domain.DTO.CourseDTO(c.id, c.name, c.description)
        FROM course c
        WHERE c.id NOT IN (
          SELECT sc.courseId
          FROM student_course sc
          WHERE sc.studentId = :id
        )
      """)
      Optional<List<CourseDTO>> findNotEnrolledCourses(@Param("id")UUID id);
}
