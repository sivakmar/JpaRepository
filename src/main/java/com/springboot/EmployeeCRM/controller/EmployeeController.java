package com.springboot.EmployeeCRM.controller;

import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService thEmployeeService){
        employeeService=thEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getById(@PathVariable("employeeId")int id){
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        Employee dbEmployee=employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")int id)
    {
        employeeService.delete(id);
    }

}
