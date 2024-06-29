package com.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
	Statement stmt= conn.createStatement();
	int i = stmt.executeUpdate("delete from users where id=1");
	System.out.println(i);
	}

}
