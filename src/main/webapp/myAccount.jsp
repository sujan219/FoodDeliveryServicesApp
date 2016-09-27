<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	<tr>
		<td><a href="<c:url value='/myprofile' />">My profile</a><br /> <a
			href="<c:url value='/myorder' />">Orders</a><br /> <a
			href="<c:url value='/orderhistory' />">Order History</a><br /></td>
		<td>
			<table>
				<tr>
					<td>Full Name :</td>
					<td>${user.fullName }(${user.userName })</td>
				</tr>
				<tr>
					<td>Email :</td>
					<td>${user.email }</td>
				</tr>
				<tr>
					<td>Address:</td>
					<td>${user.address }</td>
				</tr>
				<tr>
					<td></td>
					<td><a href="<c:url value='/user/update' />">Edit</a></td>
				</tr>

			</table>
		</td>

	</tr>

</table>