<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">

		<div id="divManageFoodItemForm">
		<table id="tblManageFoodItem">
			<thead>
			
				<tr>
					<th>Food Item Name</th>
					<th>Image</th>
					<th>Price</th>
					<th>Description</th>
					<th>Food Category</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${foodItems}" var="foodItem">
					<tr>
						<td><c:out value="${foodItem.name}" /></td>
						<td><img width="30px" height="30px" src="<c:url value="${foodItem.imgUrl}" />"/></td>
						<td><c:out value="$ ${foodItem.price}" /></td>
						<td><c:out value="${foodItem.description}" /></td>
						<td><c:out value="${foodItem.category.name}" /></td>	
						<td><a href="<c:out value="manageFoodItem/edit/${foodItem.id}"/>">Edit</a></td>
						<td><a	href="<c:out value="manageFoodItem/delete/${foodItem.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		
		</div>
		
		
	