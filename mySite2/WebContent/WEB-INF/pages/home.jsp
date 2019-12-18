<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready( function () {
	$('#myTable').dataTable({
	    "bPaginate": false,
	    "bLengthChange": false,
	    "bFilter": true,
	    "bInfo": false,
	    "bAutoWidth": false });
	
} );

</script>
</head>
<body>
	

	<div class="container">
	
	<h1>Student Schedules</h1>
	
	<!-- <form action="">
	  First name:<br>
	  <input type="text" name="firstName" value="">
	  <br>
	  Last name:<br>
	  <input type="text" name="lastName" value="" >
	  <br><br>
	  <input type="submit" value="Submit" class="btn btn-primary">
	</form>  -->
	

	<div style="margin-top:50px; text-align:center;"><a class="btn btn-primary" href="admin" > Click to Add New Data </a></div>
	
	<table id="myTable" class="display" >
	<thead>
	<tr>
	<th>First Name</th><th>Last Name</th><th>Student ID</th>
	 <th>Date</th><th>Class</th>
	</tr>
	</thead>
	<tbody>
						<c:forEach items="${personList}" var="element" varStatus="index">
						<tr>
						<td>${element.first_name[0]}</td>
						<td>${element.last_name[0]}</td>
						<td>${element.sex[0]}</td>
						<td>
						<div style="float:left;margin-right:30px;">
							<c:forEach items="${element.crime_date}" var="date">
								${date}<br/>
							</c:forEach>
						</div>
						
						</td> 
						
						<td>
						<div>
							<c:forEach items="${element.crime}" var="crime">
								${crime}<br/>
							</c:forEach>
						</div>
						</td>
						</c:forEach>
   </tbody>
</table>

</div>
</body>
</html>