<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Style for table to display customer data -->
<style type="text/css">
.myTable {
	table-layout: fixed;
	width: 100%;
	background-color: #eee;
	border-collapse: collapse;
	text-align: center
}

.myTable th {
	background-color: #008B8B;
	color: white;
	width: 30%;
}

.myTable td {
	text-align: center;
}

.myTable tr {
	border-bottom: 1px solid #ddd;
}

.myTable tr:nth-child(even) {
	background-color: #B0E0E6;
}
</style>
<!-- Heading to show customer relationship management and button to add customer -->
</head>
<body>
	<h1
		style="background-color: #008B8B; font-size: 300%; color: white; text-align: center">
		<b>CUSTOMER RELATIONSHIP MANAGEMENT</b>
	</h1>


	<table>
		<tr>
			<td><a href="AddCustomer">Add a new Customer</a></td>
	</table>
	<form action="search" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="AddCustomer" /></td>
			</tr>
		</table>
	</form>



	${error}

	<table class="myTable">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${customers}" var="c">
			<tr>
				<td>${c.firstName}</td>
				<td>${c.lastName}</td>
				<td>${c.email}</td>
				<td><a href="addCustomer?id=${c.firstName}">Update</a><a
					href="deleteCustomer?id=${c.firstName}" onclick="myFunction()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<script> 
function myFunction() { 
  confirm("Are you sure you want to delete?"); 
} 
</script>
</body>
</html>