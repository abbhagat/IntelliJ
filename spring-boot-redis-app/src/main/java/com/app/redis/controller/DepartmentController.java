package com.app.redis.controller;

import com.app.redis.model.Department;
import com.app.redis.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentService departmentService;

  @PostMapping
  public ResponseEntity<Department> create(@RequestBody Department department) {
    Department dept = departmentService.create(department);
    return ResponseEntity.status(HttpStatus.CREATED).body(dept);
  }

  @GetMapping
  public ResponseEntity<List<Department>> getAllDepartments() {
    return ResponseEntity.ok(departmentService.getAllDepartments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
    return ResponseEntity.ok(departmentService.getDepartmentById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> update(@PathVariable int id, @RequestBody Department department) {
    return ResponseEntity.ok(departmentService.update(id, department));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    departmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
