<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>
		Account List for the User : ${username}
	</h1>
	<table border="1">
		<tr>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>Balance</th>
			<th>Action</th>
		</tr>
		<c:forEach var="account" items="${accList}">
			<tr>
				<td>${account.accountnum}</td>
				<td>${account.accounttype}</td>
				<td>${account.amount}</td>
				<td/>
			</tr>
		</c:forEach>
	</table>
	<br><br><a href="/home">Go To Login Page</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
</body>
</html>