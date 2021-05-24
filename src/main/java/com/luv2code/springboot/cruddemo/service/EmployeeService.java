package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee theEmployee);
    public void deleteById(int id);
}
