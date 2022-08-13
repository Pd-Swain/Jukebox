package com.niit.jukebox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	
	Connection con = null;

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Password@123");
		System.out.println("Connection Established");
		return con;
	}
	
}
