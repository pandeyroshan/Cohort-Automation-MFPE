<%@ page
	import="com.cohortautomation.beans.User, com.cohortautomation.beans.Meeting"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My Survey</title>
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
	cursor: pointer;
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
			<%
				User user = (User) session.getAttribute("user");
				
				if(user.isAdmin()){
					out.print("<p class=\"myNavLink\" onclick=\"location.href='\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/all-cohort'\">Cohorts</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/all-sme'\">SMEs</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/all-mentor'\">Mentors</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/all-coach'\">Coaches</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/all-trainer'\">Trainer</p>");
				} else if(user.isSME()){
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Cohorts</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Meetings</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Survey</p>");
				} else if(user.isMentor()){
					out.print("<p class=\"myNavLink\" onclick=\"location.href='\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Cohorts</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Meetings</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Survey</p>");
				} else if(user.isCoach()){
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/my-cohort'\"><strong>Cohorts</strong></p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Meetings</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href=''\">Surveys</p>");
				} else if(user.isTrainer()){
					out.print("<p class=\"myNavLink\" onclick=\"location.href='\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/my-cohort'\">Cohorts</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Meetings</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Survey</p>");
				} else {
					out.print("<p class=\"myNavLink\" onclick=\"location.href='\">Homepage</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/my-cohort'\">Cohorts</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Meetings</p>");
					out.print("<p class=\"myNavLink\" onclick=\"location.href='/'\">Survey</p>");
				}
			%>
			<hr>
			<p class="myNavLink">Change Password</p>
			<p class="myNavLink">My Profile</p>
		</div>

		<div class="text-center p-3 myFooter"
			style="background-color: rgba(0, 0, 0, 0.2);">
			<%
				if(user.isAdmin()){
					out.print("<p class=\"mb-2\">Admin Dashboard</p>");
				} else if(user.isSME()) {
					out.print("<p class=\"mb-2\">SME Dashboard</p>");
				} else if(user.isMentor()) {
					out.print("<p class=\"mb-2\">Mentor Dashboard</p>");
				} else if(user.isCoach()) {
					out.print("<p class=\"mb-2\">Coach Dashboard</p>");
				} else if(user.isTrainer()) {
					out.print("<p class=\"mb-2\">Trainer Dashboard</p>");
				} else {
					out.print("<p class=\"mb-2\">Member Dashboard</p>");
				}
			%>
		</div>
	</div>

	<div class="main px-4">
		<div class="text-right mt-2 mr-2">
			<span style="font-size: 15px" class="mr-2">Welcome
				${user.getFullName() }</span> <a href="/logout"><img
				src="/resources/img/logout.png" class="mt-1"
				style="width: 15px; height: 15px;"></a>
		</div>

		<!-- Breadcrumb -->
		<small class="font-weight-light text-secondary"> <span
			style="font-size: 15px;"> <a href="/">Home</a> /
		</span> <span style="font-size: 15px;"> View Cohort -
				${cohort.getName() } </span>
		</small>
		

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