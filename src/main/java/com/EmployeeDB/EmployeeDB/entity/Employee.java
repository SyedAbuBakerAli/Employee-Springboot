package com.EmployeeDB.EmployeeDB.entity;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Employee {


    @Id
    private String employeeId;

    private String employeeName;

    private String  phoneNumber;

    private String email;

    private String reportsTo;

    private String profileImage;



}
