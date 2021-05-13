<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300&display=swap" rel="stylesheet">

    <title>CA - Change Password</title>
  </head>
  <body style="font-family: 'Nunito Sans', sans-serif;">

  	<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-lg p-2 mb-5 rounded">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Cohort Automation</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Welcome Roshan</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="#">Notifications<sup>&#x1F534;</sup></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="#">Change Password</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="#">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>

<div class="container-fluid">
	<div class="card mt-4">
		  <div class="card-header text-center">
		    Change Password
		  </div>
		  <div class="card-body">
		  
		  <%
		  	if(session.getAttribute("oldPasswordErrorMessage")!=null)
		  	{
		  		out.print("<p class=\"text-center\">");
		  		out.print(session.getAttribute("oldPasswordErrorMessage"));
		  		out.print("</p>");
		  	}
		  %>
		  	
		  	<form method="post">
			  <div class="form-group mb-3">
			    <label for="exampleInputEmail1">Old Password</label>
			    <input type="password" class="form-control" name="oldPassword" placeholder="Provide your Old Password" required="required">
			  </div>
			  <div class="form-group mb-3">
			    <label for="exampleInputEmail1">New Password</label>
			    <input type="password" class="form-control" name="newPassword" placeholder="Create a New Password" required="required">
			  </div>
			  <div class="form-group mb-3">
			    <label for="exampleInputEmail1">Confirm New Password</label>
			    <input type="password" class="form-control" name="confirmNewPassword" placeholder="Confirm New Password" required="required">
			  </div>
			   <div class="form-group form-check">
				    <input type="checkbox" class="form-check-input" id="keepMeLoggedIn" name="keepMeLoggedIn">
				    <label class="form-check-label" for="exampleCheck1">Keep me logged In</label>
				  </div>
			  <div class="text-end">
			  	<button type="submit" class="btn btn-primary">Change My Password</button>
			  </div>
			</form>
		  	
		  </div>
		</div>
	</div>

	<script>
		window.addEventListener('load', () => {
		  const now = new Date();
		  now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
		  document.getElementById('startDateTime').value = now.toISOString().slice(0, -1);
		  document.getElementById('endDateTime').value = now.toISOString().slice(0, -1);
		});
	</script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>