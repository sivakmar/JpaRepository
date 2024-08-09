package com.springboot.EmployeeCRM.service.implementation;
import com.springboot.EmployeeCRM.entity.Employee;
import com.springboot.EmployeeCRM.repository.EmployeeRepository;
import com.springboot.EmployeeCRM.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository=theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
         employeeRepository.deleteById(id);
    }
}
