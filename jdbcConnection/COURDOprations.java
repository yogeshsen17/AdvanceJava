package com.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class COURDOprations {
	public static void main(String[] args) throws Exception {
		add();
		delete();
		search();
		Authentication();
	}

	private static void Authentication() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from users where loginId=2");
		System.out.println(rs);
		
	}

	private static void search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from users where firstName= 'Aashu");
		System.out.println(rs);
	}
	

	private static void delete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		Statement stmt= conn.createStatement();
		int i= stmt.executeUpdate("delete from users where id=3");
		System.out.println(i);
		
	}

	private static void add() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
	Statement stmt= conn.createStatement();
	int i = stmt.executeUpdate(
			"insert into users values(5, 'yashi', 'soni', 'yashi@gmail.com', 'pass123', '2003-01-22', 'female')");
System.out.println(i);
	}

}
