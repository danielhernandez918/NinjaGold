<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container">
		<div class= "my-2">
			<label>Your Gold: </label>
			<input type="number" value=${gold}>
		</div>
		<div class="d-flex justify-content-between">
			<form action="/Gold/process" method="post"  class="border border-dark px-2 py-2 text-center">
				<p>Farm</p>
				<input type="hidden" name="location" value="farm">
				<p>(earns 10-20 gold)</p>
				<button>Find Gold!</button>
			</form>
			<form action="/Gold/process" method="post"  class="border border-dark px-2 py-2 text-center">
				<p>Cave</p>
				<input type="hidden" name="location" value="cave">
				<p>(earns 5-10 gold)</p>
				<button>Find Gold!</button>
			</form>
			<form action="/Gold/process" method="post"  class="border border-dark px-2 py-2 text-center">
				<p>House</p>
				<input type="hidden" name="location" value="house">
				<p>(earns 2-5 gold)</p>
				<button>Find Gold!</button>
			</form>
			<form action="/Gold/process" method="post"  class="border border-dark px-2 py-2 text-center">
				<p>Quest</p>
				<input type="hidden" name="location" value="quest">
				<p>(earns 0-50 gold)</p>
				<button>Find Gold!</button>
			</form>
		</div>
		<div class="d-flex flex-column">
			<label>Activities:</label>
				<div class= "border border-dark p-2">
					<c:forEach var="activity" items="${log}">
						<c:if test = "${activity.contains('earned')}">
	         			     <p style="color: green"><c:out value="${activity}"/></p>
	         			</c:if>
	         			<c:if test = "${activity.contains('lost')}">
	         			     <p style="color: red"><c:out value="${activity}"/></p>
	         			</c:if>
	     			</c:forEach>
     			</div>
		</div>
	</div>
<body>
</html>