<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Heading to display customer management system and it's styles -->
	<h1
		style="background-color: #008B8B; font-size: 300%; color: white; text-align: center">
		<b>CUSTOMER RELATIONSHIP MANAGEMENT</b>
	</h1>
	<br>
	<h3>
		<b>Save Customer</b>
	</h3>
	<br>

	<!-- Form to take customer data from user and save it -->
	<form action="save" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" value="${customer.firstName}"
					name="firstName" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" value="${customer.lastName}"
					name="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" value="${customer.email}" name="email" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden"
					value='${customer.firstName}' name="firstName" /><input
					type="submit" value="Save" /></td>
			</tr>
		</table>

	</form>
</body>
</html>