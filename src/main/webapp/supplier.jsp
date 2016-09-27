<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> 
<h2>Dashboard</h2>

<form action="supplier/makeDelivery" method="post">
	<input type="submit" value="Make delivery" />
	<table border=1>
		<tr>
			<td><input type="checkbox" id="selecctall"/> Select All</td>
			<td></td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td><input class="checkbox" type="checkbox" name="orderIds[]" value="${order.id}" /></td>
				<td>
					<b><a href="<c:url value='/order/${order.id }' />">OrderId#${order.id} ${order.customer.fullName}</a></b>
					<ul>
					<c:forEach items="${order.orderLines}" var="orderline">
						
							<li>${orderline.foodItem.name} (${orderline.quantity} * $${orderline.foodItem.price})</li>
						
					</c:forEach>
					</ul>
					<div style="float:right">
						Total : $${order.getTotalPrice()}						
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
<script language="JavaScript">
$(document).ready(function() {
	$("#selecctall").change(function () {
	    $("input:checkbox").prop('checked', $(this).prop("checked"));
	});
});
</script>
