<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>user login</title>
</head>
<body>
<h1>User Login Page</h1>
<p>Please login to AppWorks here</p>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/login.html">
<table>
<tbody>
	<tr>
		<td>User Name:</td>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><form:input path="rating" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>