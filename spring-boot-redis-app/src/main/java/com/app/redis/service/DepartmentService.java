package com.app.redis.service;

import com.app.redis.model.Department;
import com.app.redis.repository.DepartmentDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * The service uses Spring's cache abstraction. @Cacheable reads the shared cache before invoking the method;
 * @CacheEvict invalidates a cached entry after a successful method invocation.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

  private final DepartmentDAO departmentDAO;

  @Transactional
  public Department create(Department department) {
    log.info("Creating department: {}", department.getDeptName());
    return departmentDAO.save(department);
  }

  public List<Department> getAllDepartments() {
    return departmentDAO.findAll();
  }

  @Cacheable(cacheNames = "department", key = "#deptId")
  public Department getDepartmentById(int deptId) {
    return departmentDAO.findById(deptId).orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptId));
  }

  @Transactional
  @CacheEvict(cacheNames = "department", key = "#department.deptId")
  public Department update(int deptId, Department department) {
    Department dept = getDepartmentById(deptId);
    dept.setDeptName(department.getDeptName());
    dept.setDeptLoc(department.getDeptLoc());
    return departmentDAO.save(dept);
  }

  @Transactional
  @CacheEvict(cacheNames = "department", key = "#deptId")
  public void delete(int deptId) {
    departmentDAO.deleteById(deptId);
    log.info("Deleted department with ID: {}", deptId);
  }

}
