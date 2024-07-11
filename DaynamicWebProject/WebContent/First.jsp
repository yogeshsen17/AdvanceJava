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

		<form action="FirstServlet" method="post">
			<h1>Please Fill Details</h1>

			<table>
				<tr>

					<th>FirstName</th>

					<td><input type="text" name="firstName"
						Placeholder="Enter First Name"></td>

				</tr>
				<tr>

					<th>LastName</th>

					<td><input type="text" name="lastName"
						Placeholder="Enter Last Name"></td>

				</tr>
				<tr>

					<th>loginId</th>

					<td><input type="email" name="loginId"
						Placeholder="Enter loginId"></td>

				</tr>
				<tr>

					<th>Password</th>

					<td><input type="password" name="password"
						Placeholder="Enter Password"></td>

				</tr>
				<tr>

					<th>DOB</th>

					<td><input type="date" name="dob" Placeholder="Enter DOB"></td>

				</tr>
				<tr>

					<th>Gender</th>

					<td><input type="text" name="gender"
						Placeholder="Enter Gender"></td>

				</tr>
				<tr>

					<th>Click</th>

					<td><input type="submit" name="operation"></td>

				</tr>




			</table>


		</form>
	</Center>

</body>
</html>