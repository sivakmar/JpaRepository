package com.springboot.EmployeeCRM.dao;

import com.springboot.EmployeeCRM.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOImpl(EntityManager theentityManager){
        entityManager=theentityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("From Employee",Employee.class);
        List<Employee> employeesList=theQuery.getResultList();
        return employeesList;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {
        Employee toBeDeleted=findById(id);
        entityManager.remove(toBeDeleted);
    }
}
