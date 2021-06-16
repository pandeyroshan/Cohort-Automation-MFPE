<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<title>View Cohort</title>
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 25%;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #9BB0DA;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 25%; /* Same as the width of the sidenav */
	font-size: 28px; /* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

.myFooter {
	height: 50px;
	position: fixed;
	bottom: 0%;
	width: 25%;
	background-color: #393838;
	opacity: 1;
}

div.scrollmenu {
	background-color: #C4C4C4;
	overflow: auto;
	white-space: nowrap;
}

div.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

div.scrollmenu a:hover {
	background-color: #777;
}

span {
	font-size: 20px;
	margin-right: 5px;
}

p.cohort-label {
	padding: 0;
	margin: 0;
}

.card-body {
	min-height: 300px;
	min-width: 300px;
	margin-right: 5px;
}

.main {
	overflow: scroll;
}

::-webkit-scrollbar {
	width: 0px;
	background: transparent;
}

.myNavLink:hover {
	font-weight: bold;
	cursor: pointer;
}

.cohortClass {
	cursor: pointer;
	border: solid;
	border-color: #C4C4C4;
}

.cohortClass:hover {
	border-color: #fff;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="sidenav">
		<div class="text-center">
			<img class="img-responsive mb-5" src="/resources/img/logo.png"
				style="width: 70%;">

			<div class="input-group mb-3 p-4">
				<input type="text" class="form-control p-3"
					placeholder="Enter Keywords .." aria-label="Recipient's username"
					aria-describedby="basic-addon2">
				<div class="input-group-append">
					<span class="input-group-text" id="basic-addon2">&#128269;</span>
				</div>
			</div>
		</div>

		<div class="text-left pl-5 pt-3 pr-5">
			<p class="myNavLink" onclick="location.href='/'">Homepage</p>
			<p class="myNavLink" onclick="location.href='/all-cohort'">Cohorts</p>
			<p class="myNavLink" onclick="location.href='/all-sme'">SMEs</p>
			<p class="myNavLink" onclick="location.href='/all-mentor'">Mentors</p>
			<p class="myNavLink" onclick="location.href='/all-coach'">Coaches</p>
			<p class="myNavLink" onclick="location.href='/all-trainer'">Trainer</p>
			<hr>
			<p class="myNavLink">Change Password</p>
			<p class="myNavLink">My Profile</p>
		</div>

		<div class="text-center p-3 myFooter"
			style="background-color: rgba(0, 0, 0, 0.2);">
			<p class="mb-2">Admin Dashboard</p>
		</div>
	</div>

	<div class="main px-4">
		<div class="text-right mt-2 mr-2">
			<span style="font-size: 15px" class="mr-2">Welcome admin</span> <a
				href="/logout"><img src="/resources/img/logout.png" class="mt-1"
				style="width: 15px; height: 15px;"></a>
		</div>

		<!-- Breadcrumb -->
		<small class="font-weight-light text-secondary"> <span
			style="font-size: 15px;"> <a href="/">Home</a> /
		</span> <span style="font-size: 15px;"> View Cohort -
				${cohort.getName() } </span>
		</small>
		<div class="text-right">
			<button class="btn btn-success" data-toggle="modal" data-target="#exampleModal">Edit</button>
			
			<!-- Edit Cohort Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Edit ${cohort.getName() }</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body text-left">
			      	<form method="post" action="/edit-cohort">
			      		<input type="hidden" name="oldCohortId" value=${cohort.getName() }>
	                    <label style="font-size: 15px;">Cohort Code</label>
	                    <input type="text" class="form-control" name="cohortCode" placeholder="Provide a cohort Code" value=${cohort.getName() }>
	                    
	                    <label style="font-size: 15px;">Cohort Description</label>
	                    <input type="text" class="form-control" name="cohortDesc" placeholder="Provide a cohort Description ex - Advance Java Track" value=${cohort.getDescription() }>
	
	                    <label style="font-size: 15px;">Start Date</label>
	                    <input type="date" class="form-control" name="startDate">
	
	                    <label style="font-size: 15px;">Total Weeks</label>
	                    <input type="number" class="form-control" name="totalWeeks" placeholder="Provide number of weeks">
	
	                    <label for="exampleInputEmail1" style="font-size: 15px;">Trainer</label>
	                    <div class="d-flex">
	                        <select class="form-control" name="trainerID">
	                        <c:forEach var="trainer" items="${allTrainer}">
	                          <option value="${trainer.getUsername() }">${trainer.getFullName()}</option>
	                        </c:forEach>
	                        </select>
	                    </div>
	
	                    <label for="exampleInputEmail1" style="font-size: 15px;">Coach</label>
	                    <div class="d-flex">
	                        <select class="form-control" name="coachID">
	                          <c:forEach var="coach" items="${allCoach}">
	                          	<option value="${coach.getUsername() }">${coach.getFullName()}</option>
	                          </c:forEach>
	                        </select>
	                    </div>
	
	                    <label for="exampleInputEmail1" style="font-size: 15px;">Mentor</label>
	                    <div class="d-flex">
	                        <select class="form-control" name="mentorID">
	                          <c:forEach var="mentor" items="${allMentor}">
	                          	<option value="${mentor.getUsername() }">${mentor.getFullName()}</option>
	                          </c:forEach>
	                        </select>
	                    </div>
	
	                    <label for="exampleInputEmail1" style="font-size: 15px;">SMEs</label>
	                    <div class="d-flex">
	                        <select class="form-control" name="smeID">
	                          <c:forEach var="sme" items="${allSME}">
	                          	<option value="${sme.getUsername() }">${sme.getFullName()}</option>
	                          </c:forEach>
	                        </select>
	                    </div>
	                    <hr>
	                    <div class="text-right mt-3">
	                        <button type="submit" class="btn btn-success">Update Cohort</button>
	                    </div>
	                </form>
			      </div>
			    </div>
			  </div>
			</div>
			
			<button onclick="location.href='/delete-cohort?cohortId=${cohort.getName()}'" class="btn btn-danger">Delete</button>
		</div>
		
		<!-- Show basic information -->
		<small class="font-weight-light" style="font-size: 20px;">
			<p style="margin:0; padding:0;">Cohort ID - ${cohort.getName() }</p>
			<p style="margin:0; padding:0;">Cohort Description - ${cohort.getDescription() }</p>
			<p style="margin:0; padding:0;">Cohort Start Date - ${cohort.getStartdate() }</p>
		</small>
		<hr>
		
		
		<!-- Show SME, Mentor, Coach and Trainer -->
		<div class="container-fluid py-2">
	        <div class="d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3">
	            <div class="pt-3 px-3 mr-3 bg-white text-center rounded">
	              <img src="/resources/img/profile-user.png" class="img-responsive" style="width: 50px; height: 50px;">
	              <p style="font-size: 15px;" class="text-center mt-2">${cohort.getSME().getFullName()} (SME)</p>
	              <button onclick="location.href='/view-profile?username=${cohort.getSME().getUsername()}'" class="btn btn-success btn-sm mb-3">view profile</button>
	            </div>
	            
	            <div class="pt-3 px-3 mr-3 bg-white text-center rounded">
	              <img src="/resources/img/profile-user.png" class="img-responsive" style="width: 50px; height: 50px;">
	              <p style="font-size: 15px;" class="text-center mt-2">${cohort.getMentor().getFullName()} (Mentor)</p>
	              <button onclick="location.href='/view-profile?username=${cohort.getMentor().getUsername()}'" class="btn btn-success btn-sm mb-3">view profile</button>
	            </div>
	            
	            <div class="pt-3 px-3 mr-3 bg-white text-center rounded">
	              <img src="/resources/img/profile-user.png" class="img-responsive" style="width: 50px; height: 50px;">
	              <p style="font-size: 15px;" class="text-center mt-2">${cohort.getCoach().getFullName()} (Coach)</p>
	              <button onclick="location.href='/view-profile?username=${cohort.getCoach().getUsername()}'" class="btn btn-success btn-sm mb-3">view profile</button>
	            </div>
	            
	            <div class="pt-3 px-3 mr-3 bg-white text-center rounded">
	              <img src="/resources/img/profile-user.png" class="img-responsive" style="width: 50px; height: 50px;">
	              <p style="font-size: 15px;" class="text-center mt-2">${cohort.getTrainer().getFullName()} (Trainer)</p>
	              <button onclick="location.href='/view-profile?username=${cohort.getTrainer().getUsername()}'" class="btn btn-success btn-sm mb-3">view profile</button>
	            </div>
	        </div>
      	</div>
      	
      	
		<p class="text-center text-success" style="font-size: 20px;">Cohort Members</p>
		<table class="table table-striped" style="font-size: 15px;">
			<thead>
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Cohort ID</th>
					<th scope="col">Description</th>
					<th scope="col">Start Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cohort" items="${cohorts}" varStatus="theCount">
					<tr>
						<td>${theCount.count}</td>
						<td>${cohort.getName() }</td>
						<td>${cohort.getDescription() }</td>
						<td>${cohort.getStartdate() }</td>
					</tr>
	            </c:forEach>
			</tbody>
		</table>

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>