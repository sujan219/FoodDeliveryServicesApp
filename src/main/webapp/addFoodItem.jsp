<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">

<div id="foodItemForm">

<h1>Add Food Item</h1>

	<form action="${editItem.id>0 ? '../add' : ''}"
		enctype="multipart/form-data" method="post">

		<input type="hidden" name="foodItemId" value="${editItem.id}" /> 
		<input type="hidden" name="imgUrl" value="${editItem.imgUrl}" /> 
			
		<table>
			<tr>
				<td>Food Item Name:</td>
				<td><input type="text" name="foodItemName"
					value="${editItem.name} " /></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><input type="text" name="foodItemDesc"
					value="${editItem.description}" /></td>
			</tr>

			<tr>
				<td>Price per Item:</td>
				<td><input type="text" name="price" value="${editItem.price}" /></td>
			</tr>
			<tr>
				<td>File to upload:</td>
				<td><input id="inputChoose" type="file" name="file"><br /></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<img width="80px" height="80px" src="<c:url value="${editItem.imgUrl}" />" />
				</td>
			</tr>
			
			<tr>
				<td>Choose Category:</td>
				<td>
					<select name='categoryId'>
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}"
					${category.id == editItem.id ? 'selected="selected"' : ''}>
					${category.name}</option>
			</c:forEach>
		</select>
				</td>
			</tr>
			<tr>
			<td>
					
				</td>
				<td>
					<button class="button" type="submit">${editItem.id>0 ? 'Update' : 'Add'}</button>
				</td>
			</tr>
		</table>

	</form>

</div>
