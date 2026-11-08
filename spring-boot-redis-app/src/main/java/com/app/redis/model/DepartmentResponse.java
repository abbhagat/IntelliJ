package com.app.redis.model;

// API response and the Object stored in Redis cache(never the JPA entity)
public record DepartmentResponse(Long deptId, String deptName, String deptLoc) {

  public static DepartmentResponse fromEntity(Department department) {
    return new DepartmentResponse((long) department.getDeptId(), department.getDeptName(), department.getDeptLoc());
  }
}
