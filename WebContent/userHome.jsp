<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Details</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<form action="userHome" method="post"
		enctype="multipart/form-data">
		<DIV align="center" style="margin-top: 20px; color:teal" >
		Select File to Upload:<input type="file" name="fileName"> 
		<input type="submit" value="Upload">
		</DIV>
	</form>
</body>
</html>