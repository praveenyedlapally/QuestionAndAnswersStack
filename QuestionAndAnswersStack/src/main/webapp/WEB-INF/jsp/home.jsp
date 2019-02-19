    
 <%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signup {
  background-color: white;
  text-align: center;
}
</style>
</head>
<body>
 <div class="container" style="width:50%; height: 50%">
    <h1>Login</h1>
    <p>Please login to access the stack.</p>
    <hr>
    <form:form id="login-form" method="POST" action="#"
		role="form" style="display: block;" modelAttribute="questions">

		<span style="color:red;">
			<form:errors path="*"/>
			</span>
			<br/>
			form:<textarea path="question" rows="4" cols="25"></textarea>
	
		     <div class="clearfix">
			<input type="submit" value="submit"/>
			
			</div>
		</form:form>
</div>

</body>
</html>
