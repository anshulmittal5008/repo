<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>List Arithmetic Expressions</title>
</head>
<body>
	<h2>Arithmetic Expressions List</h2>

	<a href="/evaluateArithmeticExpressionPage">Evaluate
		Arithmetic Expression</a>

	<br />

	<table border=1>
		<tr>
			<td>Arithmetic Expression</td>
			<td>Result</td>
		</tr>
		<c:forEach var="arithmeticExpression" items="${arithmeticExpressions}">
			<td>${arithmeticExpression.expression}</td>
			<td>${arithmeticExpression.result}</td>
	</table>

</body>
</html>