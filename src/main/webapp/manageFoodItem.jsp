<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	
	
	<table border=1>
        <thead>
            <tr>
                <th>Food Item Name</th>
                <th>Description</th>
                <th>Food Category</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${foodItems}" var="foodItem">
                <tr>
                    <td><c:out value="${foodItem.name}" /></td>
                    <td><c:out value="${foodItem.description}" /></td>
                    <td><c:out value="${foodItem.category.name}" /></td>
                    
                    <td><a href="manageFoodItem/edit/<c:out value="${foodItem.id}"/>">Edit</a></td>
                    <td><a href="manageFoodItem/delete/<c:out value="${foodItem.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
        
    </table>
	
	<form action="manageFoodItem/add">
		<button type="submit">New Food Item</button>
	</form>
	
</body>
</html>