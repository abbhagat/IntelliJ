package com.app.redis.exception;

public class DepartmentNotFoundException extends RuntimeException {

  public DepartmentNotFoundException(Long deptId) {
    super("Department with ID " + deptId + " not found.");
  }
}
