package com.nit.controller;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("payroll")
public class PayRollOperationController {
    @Autowired
    private IEmployeeMgmtService service;
    public List<Employee> showAllEmployeesByDesignation(String desg1,String desg2,String desg3) throws Exception{
        //use service
        return service.fetchEmployeeByDesignation(desg1, desg2, desg3);
    }

}
