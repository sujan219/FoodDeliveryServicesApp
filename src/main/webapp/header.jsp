<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/css/menu.css" />" >

<span><h3>Food Delivery System</h3></span>
<b>Food Delivery System</b> <span style="float:right">${user.userName} | <a href="${pageContext.request.contextPath}/user/update">My account</a> | <a href="${pageContext.request.contextPath}/logout" >Logout</a></span>
<%@ include file="menu.jsp" %>
