<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NextGenGlobal Example</title>
</head>
<body>
<h2>Palindrome POC</h2>
	<form:form method="POST" action="/nextgenglobal/create" modelAttribute="palindromeForm">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" />     
	    <input type="submit" value="Submit" />
	</form:form>
	<c:if test="${not empty items}">
		<table>
			<thead>
				<tr>
					<th>SI No</th>
					<th>Palindromes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<table>
		
	</table>
</body>
</html>