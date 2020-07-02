<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NextGenGlobal Example</title>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>
<h2>Palindrome POC</h2>
	<form:form method="POST" action="/nextgenglobal/create" modelAttribute="palindromeForm">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" id="palindrome" />     
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
	<script type="text/javascript">
		function split(val) {
		    return val.split(/,\s*/);
		}
		function extractLast(term) {
		    return split(term).pop();
		}
		$(document).ready(function() {	
			$( "#palindrome").autocomplete({
			    source: function (request, response) {
			        $.getJSON("${pageContext. request. contextPath}/autocomplete", {
			            term: extractLast(request.term)
			        }, response);
			    },
			    search: function () {
			        // custom minLength
			        var term = extractLast(this.value);
			        if (term.length < 1) {
			            return false;
			        }
			    },
			    focus: function () {
			        // prevent value inserted on focus
			        return false;
			    },
			    select: function (event, ui) {
			        var terms = split(this.value);
			        // remove the current input
			        terms.pop();
			        // add the selected item
			        terms.push(ui.item.value);
			        // add placeholder to get the comma-and-space at the end
			        terms.push("");
			        this.value = terms.join(", ");
			        return false;
			    }
			});
	});
</script>
</body>
</html>