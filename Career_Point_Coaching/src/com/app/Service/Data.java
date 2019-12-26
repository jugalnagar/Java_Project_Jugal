package com.app.Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {
	public static Connection cannect() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Coaching_Management", "root", "root");
		return con;
	}

}
