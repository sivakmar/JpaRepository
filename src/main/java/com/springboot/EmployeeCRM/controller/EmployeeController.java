package com.springboot.EmployeeCRM.controller;

import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.exception.ApiSuccessResponse;
import com.springboot.EmployeeCRM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theemployeeService){
        this.employeeService=theemployeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiSuccessResponse> getAllEmployees(){
        List<Employee> employees=employeeService.getAllEmployees();
        ApiSuccessResponse response=new ApiSuccessResponse(true,"[]",employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
