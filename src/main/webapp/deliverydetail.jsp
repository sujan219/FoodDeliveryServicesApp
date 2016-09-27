<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<h2>Delivery Items detail</h2>
	

	<c:if test="${delivery.status != 'COMPLETE'}">
		<form method="post">
			Enter Miles Travelled: <input type="text" name="distance" />
			<br/>
			<input type="submit" value="Delivered!" />
		</form>
		<br/><br/>
	</c:if>
		<div class="divBorder" id="rowOrder">
			<div class="divTitle">
				<b>Start date: <fmt:formatDate type="both" value="${delivery.startDateTime}" /> 
				<c:if test="${delivery.status == 'COMPLETE'}">
					<div>Delivered on : <fmt:formatDate type="both" value="${delivery.endDateTime}" /></div>
				</c:if>    
				</b>
				<b><span style="float:right"> ${delivery.status}</span></b>
			</div>
			<c:forEach items="${delivery.orders}" var="order">
				<b>
					<div>Price : ${order.getTotalPrice()}</div>
					<div>Ordered by (${order.customer.fullName})</div>
					<div>Address: ${order.customer.address}</div>
				</b>
				<table>
					<tr>
						<td></td>
						<td>Item</td>
						<td>Price</td>
						<td>Quantity</td>
						<td>Total</td>
					</tr>
	
					<c:forEach items="${order.orderLines}" var="row" varStatus="rowCounter">
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
		</div>
	
	