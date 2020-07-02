<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NextGenGlobal Example</title>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
</head>
<body>
<h2>Palindrome POC</h2>
	<c:if test="${not empty error}">
		<div style="color:red">Error: ${error}</div>
	</c:if>
	<form:form method="POST" action="/nextgenglobal/create" modelAttribute="palindromeForm">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" id="palindrome" />     
	    <input type="submit" value="Submit" />
	</form:form>
	<table id="datatable" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
		<thead>
			<tr>
				<th>SI No</th>
				<th>Palindromes</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		function split(val) {
		    return val.split(/,\s*/);
		}
		function extractLast(term) {
		    return split(term).pop();
		}
		function initDataTable() {
			var data =eval('${items}');
			var table = $('#datatable').DataTable({
				searching: false,
				"aaData": data,
				"aoColumns": [
					{ "mData": "id"},
					{ "mData": "name"}
				]
			});
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
			        event.preventDefault();
			    }
			});
		initDataTable();
	});
</script>
</body>
</html>