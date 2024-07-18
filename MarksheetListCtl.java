package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;



@WebServlet("/MarksheetListCtl.do")
public class MarksheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		try {
			List list = model.search(bean);
			request.setAttribute("MarksheetList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		if (ids != null) {
			for (String rollno : ids) {
				System.out.println("id");
				try {
					model.delete(Integer.parseInt(rollno));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			List list = model.search(bean);
			request.setAttribute("MarksheetList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);

	}

}
