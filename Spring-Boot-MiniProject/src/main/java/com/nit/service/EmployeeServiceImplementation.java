package com.nit.service;

import com.nit.dao.IEmployeeDao;
import com.nit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImplementation implements IEmployeeMgmtService {
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public List<Employee> fetchEmployeeByDesignation(String desg1, String desg2, String desg3) throws SQLException {
       //converting the designations to uppercase
        desg1=desg1.toUpperCase();
        desg2=desg2.toUpperCase();
        desg3=desg3.toUpperCase();

        //use DAO
         List <Employee> list= employeeDao.getEmployeeByDesignation(desg1,desg2,desg3);
         //sort the object in List Collection
        list.sort((t1,t2)->t1.getEmployeeNumber().compareTo(t2.getEmployeeNumber()));
        //calculate gross salary and net salary
        list.forEach(employee -> {
            employee.setGrossSalary(employee.getSalary()+(employee.getSalary()*0.5));
            employee.setNetSalary(employee.getGrossSalary()-(employee.getGrossSalary()*0.2));
        });
        return list;


    }
}
