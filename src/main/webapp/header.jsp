<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
	<h2>Food Delivery System</h2>
</div>
<div>
	<%@ include file="menu.jsp" %>
	<span style="float:left">
		<form:form action="home" method="post" commandName="searchObj"> 
			Search <form:select path="supplierId">
				<form:option value="0">All</form:option>
				<c:forEach items="${suppliers}" var="supplier">
					<form:option value="${supplier.id}">${supplier.fullName}</form:option>
				</c:forEach>
			</form:select>
			
			<form:select path="categoryId">
				<form:option value="0">All</form:option>
				<c:forEach items="${categories}" var="category">
					<form:option value="${category.id}">${category.name}</form:option>
				</c:forEach>
			</form:select>
			
			<form:input path="searchText" />
			<input type="submit" value="Search" />
		</form:form>
	</span>
	<span style="float:right">
		<c:choose>
			<c:when test="${sessionScope.user != null}">
				${sessionScope.user.userName} | <a href="<c:url value="/myCart" />">My Cart</a> |<a href="<c:url value='/user/update' />">My Account</a> | <a href="<c:url value='/logout' />" >Logout</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/login'/>">Login</a>
			</c:otherwise>
		</c:choose>
	</span>
</div>
<div><hr /></div>
