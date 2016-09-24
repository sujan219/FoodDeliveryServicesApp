<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>

<style>
	#deliveryRadiusTR{
		display:none;
	}
</style>

<script>
	function checkPassword(){
		var password = document.getElementById("password").value;
		var cPassword = document.getElementById("cPassword").value;
		if(password == cPassword){
			return true;
		}else{
			document.getElementById("cPasswordMsg").innerHTML = "Confirm password does not match!";
			return false;
		} 
	}
	
	function userTypeChanged(){
		var userType = document.getElementById("userType").value;
		var display = "none";
		if(userType == "supplier"){
			display = "table-row";
		}
		document.getElementById("deliveryRadiusTR").style.display = display;
	}
</script>
</head>
<body>
	<center>
		<form:form action="signup" modelAttribute="user" onsubmit="return checkPassword()" method="POST">
			<table>
				<tr>
					<td>Full name</td>
					<td>
						<form:input path="fullName" />
					</td>
					<td>
						<form:errors path="fullName"></form:errors>
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>
						<form:input path="address" />
					</td>
					<td>
						<form:errors path="address"></form:errors>
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						<form:input path="email" />
					</td>
					<td>
						<form:errors path="email"></form:errors>
					</td>
				</tr>
				<tr>
					<td>Contact</td>
					<td>
						<form:input path="contact" />
					</td>
					<td>
						<form:errors path="contact" ></form:errors>
					</td>
				</tr>
				<tr>
					<td>Username</td>
					<td>
						<form:input path="userName" />
					</td>
					<td>
						<form:errors path="userName"></form:errors>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<form:password path="password" id="password" />
					</td>
					<td>
						<form:errors path="password"></form:errors>
					</td>
				</tr>
				<tr>
					<td>Confirm password</td>
					<td>
						<input type="password" id="cPassword" />
					</td>
					<td>
						<span id="cPasswordMsg"></span>
					</td>
				</tr>
				<tr>
					<td>User type</td>
					<td>
						<form:select path="userType" onchange="userTypeChanged()" id="userType">
							<form:option value="consumer">Consumer</form:option>
							<form:option value="supplier">Supplier</form:option>
						</form:select>
					</td>
					<td></td>
				</tr>
				<tr id="deliveryRadiusTR">
					<td>Delivery radius</td>
					<td>
						<form:input path="deliveryRadius"/>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Signup" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>