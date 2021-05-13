<%@ page import="com.cohortautomation.beans.User" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300&display=swap" rel="stylesheet">

    <title>Cohort Automation</title>
  </head>
  <style>
  	#blink {
            transition: 0.1s;
        }
  </style>
  <body style="font-family: 'Nunito Sans', sans-serif;">

  	<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-lg p-2 mb-3 rounded">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Cohort Automation</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Welcome ${user.getUsername() }</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="#">Notifications<sup>&#x1F534;</sup></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/change-password">Change Password</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/logout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<%
		User user = (User) session.getAttribute("user");
		
		if(!user.isAdmin()){
			out.print("<div class=\"text-end\">");
			out.print("<p>Cohort Code: ${user.getCohort().getName() }</p>");
			out.print("</div>");
		} else {
			out.print("<br>");
		}
	%>

	<div class="row mx-auto">

	  <div class="col-sm-3 rounded-bottom">
	    <div class="card">
	    	<div class="card-header text-center">
    			Attendance
  			</div>
	      	<div class="card-body">
		        <p class="card-text">Total Days: 48</p>
	      	</div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3 rounded-bottom">
	    <div class="card">
	    	<div class="card-header text-center">
    			Meetings
  			</div>
	      	<div class="card-body">
		        <p class="card-text">Total Meetings: 12</p>
	      	</div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3 rounded-bottom">
	    <div class="card">
	    	<div class="card-header text-center">
    			Survey
  			</div>
	      	<div class="card-body">
		        <p class="card-text">Total Surveys: 14</p>
	      	</div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3 rounded-bottom">
	    <div class="card">
	    	<div class="card-header text-center">
    			Profiles
  			</div>
	      	<div class="card-body">
		        <p class="card-text">Total Profiles: 26</p>
	      	</div>
	    </div>
	  </div>
	  
	</div>
	<%
		if(user.isFirstLogin()){
			out.print("<p id=\"blink\" class=\"mt-4 text-center text-danger\">Please change your password for security reasons.</p>");
		} else {
			out.print("<br>");
		}
	%>
	<div class="container-fluid">
		<div class="text-end">
			<button class="btn btn-primary btn-sm">Mark me Present</button>
			<button class="btn btn-primary btn-sm">Create Meetings</button>
		</div>

		<div class="card mt-4 shadow-lg">
		  <div class="card-header text-center">
		    Meetings
		  </div>
		  <div class="card-body">
		  	<table class="table table-striped table-bordered">
			  <thead>
			    <tr>
			      <th scope="col" class="text-center">S.No.</th>
			      <th scope="col" class="text-center">Title</th>
			      <th scope="col" class="text-center">Start Time</th>
			      <th scope="col" class="text-center">End Time</th>
			      <th scope="col" class="text-center">Status</th>
			      <th scope="col" class="text-center">Joining Link</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row" class="text-center">1.</th>
			      <td class="text-center">SME Session</td>
			      <td class="text-center">Otto</td>
			      <td class="text-center">@mdo</td>
			      <td class="text-center text-success">Active</td>
			      <td class="text-center">Click here</td>
			    </tr>
			    <tr>
			      <th scope="row" class="text-center">2.</th>
			      <td class="text-center">BH Session</td>
			      <td class="text-center">Thornton</td>
			      <td class="text-center">@fat</td>
			      <td class="text-center text-danger">Cancelled</td>
			      <td class="text-center">Click here</td>
			    </tr>
			    <tr>
			      <th scope="row" class="text-center">3.</th>
			      <td class="text-center">Mentor Session</td>
			      <td class="text-center">@twitter</td>
			      <td class="text-center">@mdo</td>
			      <td class="text-center text-success">Active</td>
			      <td class="text-center">Click here</td>
			    </tr>
			  </tbody>
			</table>
		  </div>
		</div>

		<div class="card mt-4 mb-4">
		  <div class="card-header text-center">
		    Surveys
		  </div>
		  <div class="card-body">
		    <table class="table table-striped table-bordered">
			  <thead>
			    <tr>
			      <th scope="col" class="text-center">S.No.</th>
			      <th scope="col" class="text-center">Title</th>
			      <th scope="col" class="text-center">Start Time</th>
			      <th scope="col" class="text-center">End Time</th>
			      <th scope="col" class="text-center">Status</th>
			      <th scope="col" class="text-center">Joining Link</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row" class="text-center">1.</th>
			      <td class="text-center">SME Session</td>
			      <td class="text-center">Otto</td>
			      <td class="text-center">@mdo</td>
			      <td class="text-center text-success">Active</td>
			      <td class="text-center">Click here</td>
			    </tr>
			    <tr>
			      <th scope="row" class="text-center">2.</th>
			      <td class="text-center">BH Session</td>
			      <td class="text-center">Thornton</td>
			      <td class="text-center">@fat</td>
			      <td class="text-center text-danger">Cancelled</td>
			      <td class="text-center">Click here</td>
			    </tr>
			    <tr>
			      <th scope="row" class="text-center">3.</th>
			      <td class="text-center">Mentor Session</td>
			      <td class="text-center">@twitter</td>
			      <td class="text-center">@mdo</td>
			      <td class="text-center text-success">Active</td>
			      <td class="text-center">Click here</td>
			    </tr>
			  </tbody>
			</table>
		  </div>
		</div>
		
		<p class="text-end">Last Login: ${user.getLastLogin() }</p>
	</div>

	<footer class="bg-light text-center text-lg-start">
        <div class="text-center p-2" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2021 Cohort Automation:
        <a class="text-dark" href="https://mdbootstrap.com/">Cognizant</a>
        </div>
    </footer>
    
    <script type = "text/javascript" >  
	    function preventBack() { window.history.forward(); }  
	    setTimeout("preventBack()", 0);  
	    window.onunload = function () { null }; 
	    
	    var blink = document.getElementById('blink');
        setInterval(function() {
            blink.style.opacity = (blink.style.opacity == 0 ? 1 : 0);
        }, 500); 
	</script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
  </body>
</html>