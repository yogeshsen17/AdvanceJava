package com.rays.ResourceBundle;

import java.util.ResourceBundle;

public class testBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb= ResourceBundle.getBundle("com.rays.ResourceBundle.System");
		
		System.out.println("Driver=" + rb.getString("driver"));
System.out.println(rb.getString("url"));

System.out.println(rb.getString("username"));
System.out.println(rb.getString("password"));


		
	}

}

