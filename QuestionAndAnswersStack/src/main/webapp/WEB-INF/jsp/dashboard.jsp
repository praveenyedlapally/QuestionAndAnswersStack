<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<style>
		.error {
			color: #ff0000;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
	<title>Dashboard</title>
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
		<p id = "resultQuestion"></p>
		
		
		 <p><c:forEach items="${questionDtos}" var="question">
			<span></span><h4><c:out value="${question.question}"></c:out></h4>
		 		<button class="btn btn-danger navbar-btn btn-xs" data-toggle="modal" data-target="#answerQuestion">Post Question</button>
			</span>
		
			<c:forEach items="${answerDtos}" var="answer">
				<c:if test="${question.questionId == answer.questionId}">
					<br>
					<c:out value="${answer.answerText}"></c:out>
				</c:if>
				
			</c:forEach>
		</c:forEach></p> 
		
	</div>
	<div class="col-md-4">
		<button class="btn btn-danger navbar-btn" data-toggle="modal" data-target="#myModal">Post Question</button>
	</div>
</div>
  <form:form   method="POST" action="dashboard/question">
		<div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		   <h1>${email}</h1>
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Write Your Question Here ?</h4>
		        </div>
		        <div class="modal-body">
		        <p>
		        <input type="hidden" name="email" value=${email}>
		         <textarea rows="8" cols="70" name="question" id="writeQuestion" >
						 
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
  </form:form>
   <!-- Modal -->
<form:form   method="POST" action="dashboard/question">
  <div class="modal fade" id="answerQuestion" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Write Your Answer Here</h4>
        </div>
        <div class="modal-body">
           <input type="hidden" name="email" value=${email}>
		         <textarea rows="8" cols="70" name="question" id="writeQuestion" >
						 
				</textarea>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-default">Submit Question</button>
        </div>
      </div>
      
    </div>
  </div>
 </form:form>
 
  
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url: 'QuestionAndAnswersStack/dashboard/allQuestions',
			success: function(data){
			
			console.log("sucess");
				$("resultQuestion").html(data);
			}	
		});
	});

</script>
</html>