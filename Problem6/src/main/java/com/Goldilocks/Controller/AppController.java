package com.Goldilocks.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Goldilocks.Entity.Employee;
import com.Goldilocks.Utils.DBUtils;


@RestController
public class AppController {

	@GetMapping("/EmployeeData")
    public ResponseEntity<String> getEmployeeData() throws Exception{
			Connection connection = null;
        
            connection = DBUtils.linkBetween();

            String query = "SELECT empName, empAge FROM test";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                String empName = resultSet.getString("empName");
                Integer empAge = resultSet.getInt("empAge");

                Employee employee = new Employee(empName, empAge);
                employees.add(employee);
            }
            if(employees.size() > 0) {
            	
	            Integer employeeNumber = 1;
	            StringBuilder employeeData = new StringBuilder(); 
	            for (Employee employee : employees) {
	                employeeData.append("Name: " + employee.getEmpName() + ", Age: " + employee.getEmpAge()+"\n");
	            }
	            
	            System.out.println(employeeData.toString());
	            return new ResponseEntity<String>(employeeData.toString(),HttpStatus.OK);
            } 
            
            try {
                if (connection != null) {
                    DBUtils.closeConnection(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return new ResponseEntity<String>("No employees found in the database.",HttpStatus.BAD_REQUEST);    
    }
}	
