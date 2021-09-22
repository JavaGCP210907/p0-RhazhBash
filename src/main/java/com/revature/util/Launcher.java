package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.obj.Menu;

public class Launcher {
	
	public static void main(String[] args) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			System.out.println("Connected");
			
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		Menu menu = new Menu();
		
		menu.DisplayMenu();
	}

}
