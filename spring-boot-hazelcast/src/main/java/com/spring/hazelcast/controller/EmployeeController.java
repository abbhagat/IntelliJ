package com.spring.hazelcast.controller;

import com.spring.hazelcast.model.Employee;
import com.spring.hazelcast.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/getAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmp() {
        return service.getAllEmp();
    }

    @PostMapping(value = "/saveEmp", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveEmp(@RequestBody Employee emp){
        service.saveEmp(emp);
    }
}
