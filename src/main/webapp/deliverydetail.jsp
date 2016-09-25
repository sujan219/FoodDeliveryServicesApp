<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deliveries</title>
<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">
</head>
<body>
	<%@ include file="header.jsp"%>
	<center>
		<h2>Delivery detail</h2>
	</center>

	<c:if test="${delivery.status != 'COMPLETE'}">
		<form method="post">
			Enter miles travelled: <input type="text" name="distance" />
			<br/>
			<input type="submit" value="Delivered!" />
		</form>
		<br/><br/>
	</c:if>
	<div>StartDate: ${delivery.startDateTime}</div>
	<c:if test="${delivery.status == 'COMPLETE'}">
		<div>EndDate: ${delivery.endDateTime}</div>
	</c:if>
	<div>Status: ${delivery.status}</div>
	<div>Orders:</div>
	<ul class="itemList">
		<c:forEach items="${delivery.orders}" var="order">
			<li>
				<div id="rowOrder">
					<c:forEach items="${order.orderLines}" var="orderline">
						<div id="viewFoodItem">
							<span> ${orderline.foodItem.name} - ${orderline.quantity}</span>
						</div>
					</c:forEach>

					<div>Price : ${order.getTotalPrice()}</div>
					<div>Ordered by ${order.customer.fullName}</div>
					<div>From: ${order.customer.address}</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>