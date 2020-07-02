<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
</body>
</html>