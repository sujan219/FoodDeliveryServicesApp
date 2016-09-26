<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<h3>Foods</h3>
<center>
	<table>
		<c:forEach items="${items}" var="row" varStatus="rowCounter">
			<c:if test="${rowCounter.count % 3 == 1}">
				<tr>
			</c:if>
			<td><img class="no_image"
				src="<c:url value="/resources/img/no-image.png" />" /> <br />${row.name}
				<br />
				
				<sec:authorize access="!hasRole('ROLE_ADMIN') and !hasRole('ROLE_SUPPLIER')">
					<form action="" method="post">
						<input type="hidden" name="itemId" value="${row.id }" /> <input
							type="submit" value="Add to Cart">
					</form>
				</sec:authorize>
			</td>
			<c:if
				test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
				</tr>
			</c:if>
		</c:forEach>
	</table>
</center>