<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
	<h1>Add Food Item</h1>
	<form action="${editItem.id>0 ? '../add' : ''}" method="post">

		<input type="hidden" name="foodItemId" value="${editItem.id}" />
		Food Item Name: <input type="text" name="foodItemName" value="${editItem.name} " /><br />
		Description: <input type="text" name="foodItemDesc" value="${editItem.description}" /><br />
		Price per Item: <input type="text" name="price" value="${editItem.price}" /><br />
		Choose Category: <select name='categoryId'>
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select><br/>

		<button type="submit">${editItem.id>0 ? 'Update' : 'Add'}</button>
	</form>
