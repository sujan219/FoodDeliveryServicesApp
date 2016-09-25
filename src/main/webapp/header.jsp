<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<link rel="stylesheet" href="css/menu.css" >

<span><h3>Food Delivery System</h3></span>
<span style="float:right">${sessionScope.user.userName} | <a href="/logout" >Logout</a></span>
<%@ include file="menu.jsp" %>