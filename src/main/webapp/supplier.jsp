<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h2>This is supplier Dashboard</h2>

	<form action="supplier/makeDelivery" method="post">
		<input type="submit" value="Make delivery" />
		<ul class="itemList">
			<c:forEach items="${orders}" var="order">
				<li><span><input type="checkbox" name="orderIds[]" value="${order.id}" /></span> <span>
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
