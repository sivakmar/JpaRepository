package com.springboot.EmployeeCRM.controller;

import com.springboot.EmployeeCRM.dao.EmployeeDAO;
import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Employee getById(@PathVariable("employeeId")int id){
        return employeeService.findById(id);
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
