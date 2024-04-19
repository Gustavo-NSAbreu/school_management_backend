package com.web_development_class.school_management_backend.Domain.Entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "student_course")
@Table(name = "student_course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    
    @Column(name = "student_id", nullable = false)
    private UUID student_id;
    
    @Column(name = "course_id")
    private UUID course_id;

    public StudentCourse(UUID student_id, UUID course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }
}


