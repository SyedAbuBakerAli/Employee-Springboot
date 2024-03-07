package com.EmployeeDB.EmployeeDB.repository;

import com.EmployeeDB.EmployeeDB.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
