<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<h1>Expense Details</h1>
	<table>
		<tr>
			<td>Expense Name:</td>
			<td><c:out value="${ expense.name }"></c:out></td>
		</tr>
		<tr>
			<td>Expense Description:</td>
			<td><c:out value="${ expense.description }"></c:out></td>
		</tr>
		<tr>
			<td>Vendor:</td>
			<td><c:out value="${ expense.vendor }"></c:out></td>
		</tr>
		<tr>
			<td>Amount Spent:</td>
			<td>$<c:out value="${ expense.price }"></c:out></td>
		</tr>
	</table>
</body>
</html>