package com.nit.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private Integer employeeNumber;
    private String employeeName;
    private String designation;
    private Double salary;
    private Integer departmentNumber;
    private double grossSalary;
    private double netSalary;


}
