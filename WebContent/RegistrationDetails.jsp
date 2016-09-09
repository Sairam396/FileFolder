<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Details</title>
</head>
<body>

	<div align="center" style="margin-top: 30px">
	<h1 align="center"><u> Registered information </u> </h1>
		<table>
			<tr>
				<td>FirstName:</td>
				<td>
				<%= request.getAttribute("firstName")  %></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td>
				<%= request.getAttribute("lastName")  %></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%= request.getAttribute("email")  %></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><%= request.getAttribute("phone")  %></td>
				
				
				<input type="hidden" name="sessionid" value=<%= request.getParameter("session")  %>>
				
			</tr>

		</table>

	</div>
</body>
</html>