<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Corana Live Update</title>
</head>
<body class="p-3 mb-2 bg-secondary text-white">

	<div class="container-fluid">
		<div class="alert alert-secondary">
			<p class="h1">COVID-19 Dashboard</p>
			<span>as on : <%=new java.util.Date()%></span>
		</div>
		<c:if test="${not empty lists}">

			<table class="table table-striped">
				<thead>
					<td colspan="5"><strong>LIVE CASES</strong></td>
				</thead>
				<c:forEach var="listValue" items="${lists}">
					<tbody>
						<tr>
							<c:forEach var="listV" items="${listValue}" begin="0" end="3">
								<td>${listV}</td>
							</c:forEach>
							<c:forEach var="listV" items="${listValue}"
								begin="${lengthOfData-7}" end="${lengthOfData}">
								<td>${listV}</td>
							</c:forEach>
						</tr>
				</c:forEach>
				</tbody>
			</table>

		</c:if>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>