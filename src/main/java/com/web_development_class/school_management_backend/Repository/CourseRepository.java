package com.web_development_class.school_management_backend.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web_development_class.school_management_backend.Domain.DTO.EnrolledStudentDTO;
import com.web_development_class.school_management_backend.Domain.DTO.StudentDTO;
import com.web_development_class.school_management_backend.Domain.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, UUID>{

  @Query("""
    SELECT new com.web_development_class.school_management_backend.Domain.DTO.EnrolledStudentDTO(sc.id, s.id, s.name, s.registration)
    FROM student s
    JOIN student_course sc ON s.id = sc.studentId WHERE sc.courseId = :id
  """)
  Optional<List<EnrolledStudentDTO>> findEnrolledStudents(@Param("id")UUID id);

  @Query("""
    SELECT new com.web_development_class.school_management_backend.Domain.DTO.StudentDTO(s.id, s.name, s.registration)
    FROM student s
    WHERE s.id NOT IN (
      SELECT sc.studentId
      FROM student_course sc
      WHERE sc.courseId = :id
    )
  """)
  Optional<List<StudentDTO>> findNotEnrolledStudents(@Param("id")UUID id);
}