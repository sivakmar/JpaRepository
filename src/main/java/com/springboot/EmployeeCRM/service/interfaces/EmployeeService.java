package com.springboot.EmployeeCRM.service.interfaces;

import com.springboot.EmployeeCRM.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
