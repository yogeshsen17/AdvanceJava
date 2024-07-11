package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/loginCtl")
public class loginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op= request.getParameter("operation");
		System.out.println(op);
		HttpSession session= request.getSession();
		
		if(op != null) {
			session.invalidate();
			request.setAttribute("msg", "logout successfully");
		
		}
		RequestDispatcher rd= request.getRequestDispatcher("loginView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId= request.getParameter("loginId");
		String password= request.getParameter("password");
		
		UserModel model= new UserModel();
		UserBean bean= new UserBean();
		HttpSession session= request.getSession();
		try {
			bean = model.authenticate(loginId, password);
			if(bean!=null) {
				session.setAttribute("user", bean);
				
				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("msg", "invalid loginId or password");
				System.out.println("invalid loginId or password");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("loginView.jsp");
		rd.forward(request, response);
		
			
		
				
	}	
	
	
	

}
