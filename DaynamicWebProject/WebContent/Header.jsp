<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>

	<%
		UserBean user = (UserBean) session.getAttribute("user");
	String welcomeMsg= "hi";
	%>

	<%
		if (user != null) {
	%>
	<%= welcomeMsg + user.getFirstName()+ " "+ user.getLastName() %>
	<a href="loginCtl?operation=logout">logout</a> |
	<a href="UserCtl">AddUser</a> |
	<a href="UserListCtl">UserList</a> |
	<%
		} else {
	%>
	<%= welcomeMsg + "Guest" %>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="loginCtl">login</a>
	<%
		}
	%>
	<br>
	<br>

</body>
</html>