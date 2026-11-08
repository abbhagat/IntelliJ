package com.app.redis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DepartmentRequest(@NotBlank @Size(max = 100) String deptName, @NotBlank @Size(max = 100) String deptId) {}
