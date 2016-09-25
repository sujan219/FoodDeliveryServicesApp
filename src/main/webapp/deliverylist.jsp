<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<h2>List of deliveries</h2>
	</center>
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
</body>
</html>