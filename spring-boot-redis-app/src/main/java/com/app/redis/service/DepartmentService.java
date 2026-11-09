package com.app.redis.service;

import com.app.redis.model.Department;
import com.app.redis.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

  private final DepartmentRepository departmentRepository;

  @Transactional
  @CachePut(cacheNames = "DEPT_CACHE", key = "#result.deptId", unless = "#result == null")
  public Department create(Department department) {
    log.info("Creating department: {}", department.getDeptName());
    return departmentRepository.save(department);
  }

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }

  @Cacheable(cacheNames = "DEPT_CACHE", key = "#result.deptId", unless = "#result == null")
  public Department getDepartmentById(long deptId) {
    return departmentRepository.findById(deptId).orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptId));
  }

  @Transactional
  @CachePut(cacheNames = "DEPT_CACHE", key = "#result.deptId", condition = "#result != null")
  public Department update(int deptId, Department department) {
    Department dept = getDepartmentById(deptId);
    dept.setDeptName(department.getDeptName());
    dept.setDeptLoc(department.getDeptLoc());
    return departmentRepository.save(dept);
  }

  @Transactional
  @CacheEvict(cacheNames = "DEPT_CACHE", key = "#result.deptId", condition = "#result != null")
  public void delete(long deptId) {
    departmentRepository.deleteById(deptId);
    log.info("Deleted department with ID: {}", deptId);
  }

}
