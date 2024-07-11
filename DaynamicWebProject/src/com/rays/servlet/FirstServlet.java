package com.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("infomation filled");
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("lastName"));
		System.out.println(request.getParameter("loginId"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("dob"));
		System.out.println(request.getParameter("gender"));

	}

}
