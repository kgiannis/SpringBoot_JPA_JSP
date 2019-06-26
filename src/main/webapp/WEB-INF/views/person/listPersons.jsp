<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/views/globalTags.jsp"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<div class="jumbotron">
	<p>Persons in DB</p>
	<div class="well well-lg">
	
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">List of Persons</div>
			
			<!-- Table -->
			<table class="table table-hover">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>SURNAME</th>
					<th>AGE</th>
				</tr>
				<c:forEach var="person" items="${listPersons }">
					<tr>
						<td>${person.id }</td>
						<td>${person.name }</td>
						<td>${person.surname }</td>
						<td>${person.age }</td>
						<td><a class="btn btn-warning" href="<c:url value='/editPerson/${person.id}' />">Edit <span class="glyphicon glyphicon-edit"></span></a></td>
						<td><a class="btn btn-danger" href="<c:url value='/deletePerson/${person.id }' />">Delete <span class="glyphicon glyphicon-remove"></span></a></td>
					</tr>
				</c:forEach>
			</table>
 		</div>
 		
 		<a class="btn btn-info" href="<c:url value='/addPerson' />">Add New Person</a>

	</div>
	</div>
</body>
</html>