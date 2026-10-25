package com.app.redis.service;

import com.app.redis.model.Department;
import com.app.redis.repository.DepartmentDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

  public Department getDepartmentById(int id) {
    return departmentDAO.findById(id).orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
  }

  @Transactional
  public Department update(int id, Department updatedDepartment) {
    Department department = getDepartmentById(id);
    department.setDeptName(updatedDepartment.getDeptName());
    department.setDeptLoc(updatedDepartment.getDeptLoc());
    return departmentDAO.save(department);
  }

  @Transactional
  public void delete(int id) {
    departmentDAO.deleteById(id);
    log.info("Deleted department with ID: {}", id);
  }

}
