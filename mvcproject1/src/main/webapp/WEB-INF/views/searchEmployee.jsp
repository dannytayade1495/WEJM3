<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>
	<fieldset>
		<legend>:::Search Employee:::</legend>
		<table>
			<tr>
				<td><label>Enter Employee ID</label></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SEARCH"></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>