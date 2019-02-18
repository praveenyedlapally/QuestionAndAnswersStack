<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">QuickCode</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/login.htm">Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
<div class= "row">
	<div class="col-md-8">
		<h2>All Questions</h2>
		
	</div>
	<div class="col-md-4">
		<button class="btn btn-danger navbar-btn" data-toggle="modal" data-target="#myModal">Post Question</button>
	</div>
</div>
	<form action="#">
		<div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Write Your Question Here ?</h4>
		        </div>
		        <div class="modal-body">
		        <p>
		         <textarea rows="8" cols="70" name="writeQuestion" id="writeQuestion">
						Please Enter your Question Here ? 
				</textarea>
				<p>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		          <button type="submit" class="btn btn-default">Submit Question</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>
  	</form>
  
</div>
</body>
</html>