<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/views/globalTags.jsp"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
	<title>Edit Person</title>
</head>

<body>

	<div class="well well-lg">
		<form:form class="form-horizontal" modelAttribute="person">
			<fieldset>
			
			<%-- Form Name --%>
			<legend>Edit Person</legend>
			
			<%-- Id --%>
			<form:input type="hidden" path="id" id="id"/>
			
			<%-- Name--%>
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Name">Name</label>  
			  <div class="col-md-4">
			  <form:input id="Name" path="name" name="Name" type="text" placeholder="name" class="form-control input-md" />
			  </div>
			</div>
			
			<%-- Surname--%>
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Surname">Surname</label>  
			  <div class="col-md-4">
			  <form:input id="Surname" path="surname" name="Surname" type="text" placeholder="surname" class="form-control input-md" />
			  </div>
			</div>
			
			<%-- Age--%>
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Age">Age</label>  
			  <div class="col-md-4">
			  <form:input id="Age" path="age" name="Age" type="text" placeholder="age" class="form-control input-md" />
			  </div>
			</div>
			
			<%-- Actions --%>
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Update"></label>
			  <div class="col-md-8">
			    <button id="Update" type="submit" name="Update" class="btn btn-success">Update</button>
			    <a class="btn btn-default" href="<c:url value='/listPersons' />">Cancel</a>
			  </div>
			</div>
			
			</fieldset>
		</form:form>
	</div>		

</body>

</html>