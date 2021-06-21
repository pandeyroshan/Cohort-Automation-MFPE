<%@ page import="java.util.List, com.cohortautomation.beans.Cohort"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<title>My Cohort</title>
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
			<p class="myNavLink" onclick="location.href='/attendance'">Attendance</p>
			<p class="myNavLink" onclick="location.href=''">Meetings</p>
			<p class="myNavLink" onclick="location.href=''">Surveys</p>
			<p class="myNavLink" onclick="location.href=''">
				<strong>My Cohort</strong>
			</p>
			<hr>
			<p class="myNavLink" onclick="location.href='/change-password'">Change
				Password</p>
			<p class="myNavLink">My Profile</p>
		</div>

		<div class="text-center p-3 myFooter"
			style="background-color: rgba(0, 0, 0, 0.2);">
			<p class="mb-2">Member Dashboard</p>
		</div>
	</div>

	<div class="main px-4">
		<div class="text-right mt-2 mr-2">
			<span style="font-size: 15px" class="mr-2">Welcome
				${user.getFullName() }</span> <a href="/logout"><img
				src="/resources/img/logout.png" class="mt-1"
				style="width: 15px; height: 15px;"></a>
		</div>

		<small class="font-weight-light text-secondary"> <span
			style="font-size: 15px;"> <a href="/">Home</a> /
		</span> <span style="font-size: 15px;"> My Cohort </span>
		</small> <br>

		<%
			Cohort cohort = (Cohort) request.getAttribute("cohort");
		%>

		<small class="" style="font-size: 15px;">
			<p style="margin: 0; padding: 0;">${cohort.getName() }-
				${cohort.getDescription() }</p>
			<p style="margin: 0; padding: 0;">Cohort Start Date -
				${cohort.getStartdate() }</p>
		</small>
		<hr>

		<div class="container-fluid py-2">
			<div
				class="d-flex flex-row flex-nowrap scrollmenu pt-2 pb-2 pl-2 pr-3">
				<div class="pt-2 px-2 mr-2 bg-white text-center rounded">
					<img src="/resources/img/profile-user.png" class="img-responsive"
						style="width: 50px; height: 50px;">
					<p style="font-size: 15px;" class="text-center mt-2">${cohort.getSME().getFullName()}
						(SME)</p>
					<button
						onclick="location.href='/view-profile?username=${cohort.getSME().getUsername()}'"
						class="btn btn-success btn-sm mb-3">view profile</button>
				</div>

				<div class="pt-2 px-2 mr-2 bg-white text-center rounded">
					<img src="/resources/img/profile-user.png" class="img-responsive"
						style="width: 50px; height: 50px;">
					<p style="font-size: 15px;" class="text-center mt-2">${cohort.getMentor().getFullName()}
						(Mentor)</p>
					<button
						onclick="location.href='/view-profile?username=${cohort.getMentor().getUsername()}'"
						class="btn btn-success btn-sm mb-3">view profile</button>
				</div>

				<div class="pt-2 px-2 mr-2 bg-white text-center rounded">
					<img src="/resources/img/profile-user.png" class="img-responsive"
						style="width: 50px; height: 50px;">
					<p style="font-size: 15px;" class="text-center mt-2">${cohort.getCoach().getFullName()}
						(Coach)</p>
					<button
						onclick="location.href='/view-profile?username=${cohort.getCoach().getUsername()}'"
						class="btn btn-success btn-sm mb-3">view profile</button>
				</div>

				<div class="pt-2 px-2 mr-2 bg-white text-center rounded">
					<img src="/resources/img/profile-user.png" class="img-responsive"
						style="width: 50px; height: 50px;">
					<p style="font-size: 15px;" class="text-center mt-2">${cohort.getTrainer().getFullName()}
						(Trainer)</p>
					<button
						onclick="location.href='/view-profile?username=${cohort.getTrainer().getUsername()}'"
						class="btn btn-success btn-sm mb-3">view profile</button>
				</div>
			</div>
		</div>

		<p style="font-size: 15px; margin: 0; padding: 0;" class="ml-3">Members</p>
		<div class="container-fluid py-2">
			<div
				class="d-flex flex-row flex-nowrap scrollmenu pt-2 pb-2 pl-2 pr-3">

				<c:forEach var="user" items="${allMembers}">
					<div class="pt-2 px-2 mr-2 bg-white text-center rounded">
						<img src="/resources/img/profile-user.png" class="img-responsive"
							style="width: 50px; height: 50px;">
						<p style="font-size: 15px;" class="text-center mt-2">${user.getFullName() }</p>
						<button onclick="location.href=''"
							class="btn btn-success btn-sm mb-3">view profile</button>
					</div>

				</c:forEach>

			</div>
		</div>




		<div class="text-right fixed-bottom mr-3">
			<p class="font-weight-light" style="font-size: 15px;">Last Login:
				${user.getLastLogin() }</p>
		</div>
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