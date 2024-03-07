package com.EmployeeDB.EmployeeDB.controller;

import com.EmployeeDB.EmployeeDB.entity.Employee;
import com.EmployeeDB.EmployeeDB.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addemployee")
    public String addEmployee(@RequestBody Employee employee) {
        Employee addEmployee = service.addEmployee(employee);
        return "EmployeeId: " + addEmployee.getEmployeeId();
    }

    @GetMapping("/employees")
    public Page<Employee> listOfEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "employeeName") String sortBy) {
        return service.getAllEmployee(page, size, sortBy);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return service.deleteEmployee(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee EmployeeById(@PathVariable String id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/employees/manager")
    public String getNthLevelManager(
            @RequestParam String employeeId,
            @RequestParam int level) {

        Employee manager = service.getNthLevelManager(employeeId, level);
        if (manager == null) {
            return "not found";
        }

        return manager.getEmployeeName();
    }
}