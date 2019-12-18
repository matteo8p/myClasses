<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>
<body>
	

	<div class="container">
	
	<h1>Add New Data</h1>
	
	<div style="margin-top:40px;">
	<form action="admin" method="post">
	<table>
	<tr>
	<td>First name:</td><td><input type="text" name="first_name" value="" ></td>
	</tr>
	<tr>
	<td>Last name:</td><td><input type="text" name="last_name" value="" ></td>
	</tr>
	<tr>
	
	<td>Student ID:</td><td><input type="text" name="sex" value="" ></td>
	
	</tr>
	<tr>
	
	<td>Date:</td><td><input type="text" name="crime_date" value="" > </td><td>Class:</td><td><input type="text" name="crime" value="" > </td>
	
	</tr>
	<tr>
	<td>Date:</td><td><input type="text" name="crime_date" value="" > </td><td>Class:</td><td><input type="text" name="crime" value="" > </td>
	
	</tr>
	
	<tr>
	
	<td>Date:</td><td><input type="text" name="crime_date" value="" > </td><td>Class:</td><td><input type="text" name="crime" value="" > </td>
	
	</tr>
	</table>
	 
	  <input type="submit" value="Submit" class="btn btn-primary">
	</form> 
	</div>
	
	
	
	

</div>
</body>
</html>