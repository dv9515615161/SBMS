package com.nit.dao;

import com.nit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImplementation implements IEmployeeDao {
    private static final String GET_EMPLOYEES_BY_DESIGNATION = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN (?,?,?)";
    @Autowired
    private DataSource ds;

    public List<Employee> getEmployeeByDesignation(String desg1, String desg2, String desg3) throws SQLException {
        List<Employee> list = null;
        try (
                //get pooled connections
                Connection con = ds.getConnection();
                //prepare sql statements to pre-compile
                PreparedStatement ps = con.prepareStatement(GET_EMPLOYEES_BY_DESIGNATION);
        ) {
            //set values to the query parameters
            ps.setString(1, desg1);
            ps.setString(2, desg2);
            ps.setString(3, desg3);
            try (
                    //execute select query
                    ResultSet rs = ps.executeQuery();
            ) {
                list = new ArrayList<>();
                while (rs.next()) {
                    //copy each record to java bean class object
                    Employee employee = new Employee();
                    employee.setEmployeeNumber(rs.getInt(1));
                    employee.setEmployeeName(rs.getString(2));
                    employee.setSalary(rs.getDouble(3));
                    employee.setDesignation(rs.getString(4));
                    employee.setDepartmentNumber(rs.getInt(5));
                    //add java bean class obj to list collection
                    list.add(employee);

                }
            }
        } catch (Exception e) {
            throw e;
        }

        return list;
    }
}