package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
@WebServlet("/UserListCtl")

public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      UserModel model= new UserModel();
      UserBean bean= new UserBean();
      
      try {
		List list= model.search(bean);
		request.setAttribute("UserList", list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      RequestDispatcher rd= request.getRequestDispatcher("UserListView.jsp");
      rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] ids= request.getParameterValues("ids");
		UserModel model= new UserModel();
		UserBean bean= new UserBean();
		
		if(ids!= null) {
			for( String id:ids) {
				System.out.println("id ==== " + id);

			
		
		try {
			model.delete(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
		}
		
		try {
			List list= model.search(bean);
			request.setAttribute("UserList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}
	

}
