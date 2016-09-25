<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<td>Address:</td>
		<td><a href="edit">Edit profile</a></td>
	</tr>

</table>