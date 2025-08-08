package com.nit.service;

import com.nit.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeMgmtService {

    List<Employee> fetchEmployeeByDesignation(String desg1, String desg2, String desg3) throws SQLException;
}
