package com.web_development_class.school_management_backend.Domain.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrolledStudentDTO {
    UUID enrollmentId;
    UUID studentId;
    String name;
    Long registration;
}
