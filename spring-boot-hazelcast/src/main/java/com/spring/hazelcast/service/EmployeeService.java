package com.spring.hazelcast.service;

import com.spring.hazelcast.model.Employee;
import com.spring.hazelcast.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO DAO;

    public List<Employee> getAllEmp(){
        return DAO.findAll();
    }

    public void saveEmp(Employee emp){
        DAO.save(emp);
    }
}
