<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

	<h1>Add Food Item</h1>
	<form action="supplier/manageFoodItem/add" method="post">

		Food Item Name: <input type="text" name="name" /><br /> 
		Choose Category: <select name='category'>
			<c:forEach items="${categories}" var="category">
				<option value="${category.name}">${category.name}</option>
			</c:forEach>
		</select><br/>

		<button type="submit">Add</button>
	</form>
</body>
</html>