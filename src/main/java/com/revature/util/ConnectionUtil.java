package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		
		
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			System.out.println("Cannot connect to database");
		}
	
		String url = System.getenv("URL");
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");
		
		return DriverManager.getConnection(url, username, password);
		
	}
}
