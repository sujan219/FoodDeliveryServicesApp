<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
		<h2>List of deliveries</h2>
	
	<ul class="itemList">
		<c:forEach items="${deliveries}" var="delivery">
			<li>
				<div>StartDate: ${delivery.startDateTime}</div>
				<c:if test="${delivery.status == 'COMPLETE'}">
					<div>EndDate: ${delivery.endDateTime}</div>
				</c:if>
				<div>Status: ${delivery.status}</div>
				<a href="deliveries/${delivery.id}">View detail</a>
			</li>
		</c:forEach>
	</ul>
