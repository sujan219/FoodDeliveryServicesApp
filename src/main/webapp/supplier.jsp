<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../resources/css/supplier.css">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">
<title>Supplier</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<center>
		<h2>This is supplier Dashboard</h2>
	</center>

	<form action="supplier/makeDelivery" method="post">
		<input type="submit" value="Make delivery" />
		<ul class="itemList">
			<c:forEach items="${orders}" var="order">
				<li><span><input type="checkbox"
						name="orderIds[]" value="${order.id}" /></span> <span>
						<div id="rowOrder">
							<c:forEach items="${order.orderLines}" var="orderline">
								<div id="viewFoodItem">
									<span> ${orderline.foodItem.name} -
										${orderline.quantity}</span>
								</div>
							</c:forEach>

							<div>Price : ${order.getTotalPrice()}</div>
							<div>Ordered by ${order.customer.fullName}</div>
							<div>From: ${order.customer.address}</div>
						</div> <a href="order/${order.id}">
							<button type="submit">View Order Detail</button>
					</a>
				</span>
			</c:forEach>
		</ul>
	</form>

	<a href="supplier/deliveries"><button type="submit">View Deliveries</button></a>
	<a href="supplier/manageFoodItem"><button type="submit">Manage Food Items</button></a>
	<a href="#"><button type="submit">Make offer</button></a>
	<!-- <a href="supplier/manageFoodItem"><button type="submit">Order Full History</button></a>
	<a href="supplier/manageFoodItem"><button type="submit">Notification</button></a> -->

</body>
</html>