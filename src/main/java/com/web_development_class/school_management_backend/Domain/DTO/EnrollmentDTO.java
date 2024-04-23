package com.web_development_class.school_management_backend.Domain.DTO;

import java.util.UUID;

public record EnrollmentDTO(UUID studentId, UUID courseId) {}
