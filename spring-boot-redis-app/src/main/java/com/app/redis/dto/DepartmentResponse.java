package com.app.redis.dto;

import com.app.redis.model.Department;

// API response and the Object stored in Redis cache(never the JPA entity)
public record DepartmentResponse(Long deptId, String deptName, String deptLoc) {

  public static DepartmentResponse from(Department department) {
    return new DepartmentResponse((long) department.getDeptId(), department.getDeptName(), department.getDeptLoc());
  }
}
