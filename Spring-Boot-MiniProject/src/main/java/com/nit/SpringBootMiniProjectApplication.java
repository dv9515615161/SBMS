package com.nit;

import com.nit.controller.PayRollOperationController;
import com.nit.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootMiniProjectApplication {

	public static void main(String[] args) {
        //get ioc container
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringBootMiniProjectApplication.class, args);
        //get controller class object
        PayRollOperationController controller= ctx.getBean("payroll",PayRollOperationController.class);
        //invoke the business method
        try {
            List< Employee> list=controller.showAllEmployeesByDesignation("CLERK","MANAGER","SALESMAN");
            //process the result
            list.forEach(employee -> {System.out.println(employee);});


        }
        catch (Exception e){
            e.printStackTrace();
        }
        //close ioc container
        ctx.close();

	}

}
