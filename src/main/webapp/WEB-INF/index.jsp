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
	<h1>All PokeBooks</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Expense</th>
	            <th>Vendor</th>
	            <th>Amount</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach var="i" items="${ expenses }">
				<tr>
					<td><a href="/expenses/${i.id}"><c:out value="${ i.name }"></c:out></a></td>
					<td><c:out value="${ i.vendor }"></c:out></td>
					<td>$<c:out value="${ i.price }"></c:out></td>
					<td><a href="/expenses/edit/${i.id}">Edit</a>
						<form action="/expenses/delete/${i.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete"></form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Track an expense:</h1>
<form:form action="/addexpense" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
	<p>
		<form:label path="vendor">Vendor:</form:label>
		<form:errors path="vendor"/>
		<form:input path="vendor"/>
	</p>
	<p>
		<form:label path="price">Amount:</form:label>
		<form:errors path="price"/>     
		<form:input type="number" path="price"/>
	</p>    
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>