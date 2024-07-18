<%@page import="com.rays.bean.MarksheetBean"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<%@ include file="Header.jsp"%>

	<form action="MarksheetListCtl.do" method="post">

		<%
			List list = (List) request.getAttribute("MarksheetList");
		%>
		<h2>MarksheetList</h2>

		<table border="1" width="100%" border="1px">

			<tr style="background: orange">
				<th>click</th>
				<th>Action</th>
				<th>RollNo</th>
				<th>Name</th>
				<th>Chemistry</th>
				<th>Physics</th>
				<th>Maths</th>
				<th>Total</th>
				<th>Percentage</th>
			</tr>
			<%
				Iterator it = list.iterator();
			%>

			<%
				while (it.hasNext()) {
					MarksheetBean bean = (MarksheetBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids"
					value="<%=bean.getRollno()%>"></td>
					<td><a href= "MarksheetCtl.do?id= <%= bean.getId()%>">Edit</a></td>
				<td><%=bean.getRollno()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
				
				<% 
				int Total= bean.getChemistry()+ bean.getPhysics()+ bean.getMaths() ;
				int per= Total/3;
				%>
				<td><%=Total %></td>
				<td><%=per+"%" %></td>
				
				
				<%
					}
				%>
			</tr>

		</table>
		<tr>

			<td><input type="submit" name="opration" value="delete"></td>
		</tr>
		<tr>

			<td><input type="submit" name="opration" value="Update"></td>
		</tr>
	</form>
	</center>
</body>
</html>