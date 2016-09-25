<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/css/menu.css" />" >

<span><h3>Food Delivery System</h3></span>
<span style="float:right">${sessionScope.user.userName} | <a href="<c:url value="/logout" />" >Logout</a></span>
<%@ include file="menu.jsp" %>