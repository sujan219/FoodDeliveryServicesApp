<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../resources/css/supplier.css">
<title>Supplier</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<center>
		<h2>THis is supplier Dashboard</h2>
	</center>

	<c:forEach items="${orders}" var="order">
		<li>
			<div id="rowOrder">
				<c:forEach items="${order.orderLines}" var="orderline">
					<div id="viewFoodItem">
						<span> ${orderline.quantity}</span> 
						<span> - ${orderline.foodItem.name}</span>
					</div>
				</c:forEach>
				<span> - Price ${order.getTotalPrice()}</span><br/>
				<span> is ordered by ${order.customer.fullName}</span> <span>
					From: ${order.customer.address}</span> <span> Expecting to receive
					his delivery on: ${order.expectedDeliveryDate}</span>
			</div>
			<form action="order/${order.id}" method="get">
				<button type="submit">View Order Detail</button>
			</form>
		<li>
	</c:forEach>

	<form action="supplier/manageFoodItem">
		<button type="submit">Manage Deliveries</button>
		<button type="submit">Manage Food Items</button>
		<button type="submit">Make offer</button>
		<button type="submit">Order Full History</button>
		<button type="submit">Nofication</button>
	</form>

</body>
</html>