<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration form</title>
</head>

<body>
<jsp:include page="header.jsp" />
	<div align="center" style="margin-top: 30px; color: teal">
		<h1 align="center">
			<u> Register your information </u>
		</h1>
		<DIV align="center">
			<font color="red"> <%
 	          if (request.getAttribute("error") != null)
 		      out.println(request.getAttribute("error"));
                               %>
			</font>
		</DIV>
		<form action="register" method="post">
			<table>
				<tr>
					<td>FirstName:</td>
					<td><input type="text" name="firstName" value=<%= session.getAttribute("firstName")  %>></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName" value=<%= session.getAttribute("lastName")  %>></td>
				</tr>
				<tr>
					<td>userName:</td>
					<td><input type="text" name="userName" value=<%= session.getAttribute("userName")  %>></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" value=<%= session.getAttribute("email")  %>></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" value=<%= session.getAttribute("phone")  %>></td>
				</tr>
				<tr>
					<td>Address1</td>
					<td><input type="text" name="address1" value=<%= session.getAttribute("address1")  %>></td>
				</tr>
				<tr>
					<td>Address2</td>
					<td><input type="text" name="address2" value=<%= session.getAttribute("address2")  %>></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" value=<%= session.getAttribute("city")  %>></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select id="state" name="state" value=<%= session.getAttribute("state")  %> >
							<option value="NONE" selected>SELECT</option>
							<option value="CA">California</option>
							<option value="TX">Texas</option>

					</select></td>
				</tr>
				<tr>
					<td>Zip</td>
					<td><input type="text" name="zip"></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>