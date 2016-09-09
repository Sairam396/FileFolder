<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

<div align="center" style="margin-top: 30px ;color:teal">
<h1 align="center"><u> Login to Portal </u> </h1>
<DIV align="center">
<font color="red">
				<% 
				    if(request.getAttribute("error")!=null) 
					out.println(request.getAttribute("error"));
				%>
</font>
</DIV>
	<form action="login" method="post">
		<table>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="Login" value="Login"> <a href="register"><font size="2px">Click here to register</font></a>
				
				</td>
			</tr>
		</table>
	</form>
</div>


</body>
</html>