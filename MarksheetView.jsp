<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<Center>

		<form action="MarksheetCtl.do" method="post">
			<h1>Add Marksheet</h1>

			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>

			<table>
				<tr>

					<th>RollNo</th>

					<td><input type="text" name="RollNo"
						Placeholder="Enter rollno"></td>

				</tr>
				<tr>

					<th>Name</th>

					<td><input type="text" name="Name" Placeholder="Enter Name"></td>

				</tr>
				<tr>

					<th>Chemistry</th>

					<td><input type="text" name="Chemistry"
						Placeholder="Enter number"></td>

				</tr>
				<tr>

					<th>Physics</th>

					<td><input type="text" name="Physics"
						Placeholder="Enter number"></td>

				</tr>
				<tr>

					<th>Maths</th>

					<td><input type="text" name="Maths" Placeholder="Enter number"></td>

				</tr>

				<tr>

					<th>Click</th>

					<td><input type="submit" name="operation" value="save"></td>

				</tr>
			</table>


		</form>
	</Center>

</body>
</html>