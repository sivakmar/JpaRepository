package com.springboot.EmployeeCRM.dao;

import com.springboot.EmployeeCRM.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
