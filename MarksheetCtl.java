package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;



@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.sendRedirect("MarksheetView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RollNo= request.getParameter("RollNo");
		String Name= request.getParameter("Name");
		String Chemistry= request.getParameter("Chemistry");
		String Physics= request.getParameter("Physics");
		String Maths= request.getParameter("Maths");
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		try {

			bean.setRollno(Integer.parseInt(RollNo));
			bean.setName(Name);
			bean.setChemistry(Integer.parseInt(Chemistry));
			bean.setPhysics(Integer.parseInt(Physics));
			bean.setMaths(Integer.parseInt(Maths));
			model.add(bean);
			request.setAttribute("msg", "Thank you Marksheet added successfully");

		} catch (Exception e) {
			request.setAttribute("msg", "Marksheet adding failed");
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);


	}
	

}
