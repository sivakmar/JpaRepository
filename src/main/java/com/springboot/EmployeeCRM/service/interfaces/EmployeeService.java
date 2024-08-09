package com.springboot.EmployeeCRM.service.interfaces;

import com.springboot.EmployeeCRM.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
