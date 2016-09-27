<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${orders}" var="order"
	varStatus="orderCounter">
	<b>Order : ${orderCounter.count}</b>
	<table>
		<tr>
			<td>Order</td>
			<td>Item</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Total</td>
		</tr>

		<c:forEach items="${order.orderLines}" var="row"
			varStatus="rowCounter">
			<tr>
				<td>${rowCounter.count}</td>
				<td><c:out value="${row.foodItem.name }" /></td>
				<td><c:out value="${row.foodItem.price }" /></td>
				<td><c:out value="${row.quantity}" /></td>
				<td><c:out value="${row.quantity*row.foodItem.price}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:forEach>
