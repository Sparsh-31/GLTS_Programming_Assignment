package com.Goldilocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GoldilocksUtils.DBUtils;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
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

            if (!employees.isEmpty()) {
                System.out.println("Employees:");
                for (Employee employee : employees) {
                    System.out.println("Name: " + employee.getEmpName() + ", Age: " + employee.getEmpAge());
                }
            } else {
                System.out.println("No employees found in the database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    DBUtils.closeConnection(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
