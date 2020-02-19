<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customers List</title>
		<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- adding add customer button -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			<table>
				<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>					
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${customer.id}" ></c:param>
					</c:url>
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td><a href="${updateLink}">Update</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>