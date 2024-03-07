package com.EmployeeDB.EmployeeDB.service;

import com.EmployeeDB.EmployeeDB.entity.Employee;
import com.EmployeeDB.EmployeeDB.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(UUID.randomUUID().toString().split("-")[0]);
        return employeeRepo.save(employee);
    }

    public Page<Employee> getAllEmployee(int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return employeeRepo.findAll(pageable);
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepo.findById(employee.getEmployeeId()).get();
           existingEmployee.setEmployeeName(employee.getEmployeeName());
           existingEmployee.setEmail(employee.getEmail());
           existingEmployee.setReportsTo(employee.getReportsTo());
           existingEmployee.setProfileImage(employee.getProfileImage());
           existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        return employeeRepo.save(existingEmployee);

    }

    public String deleteEmployee(String id){
        employeeRepo.deleteById(id);
        return "Employee deleted";
    }

    public Employee getEmployeeById(String id){
        return employeeRepo.findById(id).get();
    }

    public Employee getNthLevelManager(String employeeId, int level) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        if (employee == null) {
            return null; // Employee not found
        }

        String reportsTo = employee.getReportsTo();
        while (reportsTo != null && level > 0) {
            employee = findEmployeeByReportsTo(reportsTo);
            if (employee == null) {
                return null; // Manager not found
            }
            reportsTo = employee.getReportsTo();
            level--;
        }

        return employee;
    }

    private Employee findEmployeeByReportsTo(String reportsTo) {
        List<Employee> employees = employeeRepo.findAll();
        for (Employee emp : employees) {
            if (emp.getEmployeeName().equals(reportsTo)) {
                return emp;
            }
        }
        return null; // Employee not found
    }





}
