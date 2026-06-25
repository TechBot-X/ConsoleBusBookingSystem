package com.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionutil {
    public static Connection getConnection () throws Exception {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mit", "root", "Sam21@2002");
            System.out.println("Connection with DB established");

            // Close connection
            
            return con;
            
      
        } catch (Exception e) {
            throw e;
        }
		
	
    }
}
