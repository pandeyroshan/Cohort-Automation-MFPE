<%@ page language="java" contentType="text/html; charset=UTF-8"
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

<title>Member Dashboard</title>
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
			<p class="myNavLink">
				<strong>Homepage</strong>
			</p>
			<p class="myNavLink" onclick="location.href='/attendance'">Attendance</p>
			<p class="myNavLink" onclick="location.href='/my-meetings'">Meetings</p>
			<p class="myNavLink" onclick="location.href='/my-surveys'">Surveys</p>
			<p class="myNavLink" onclick="location.href='/member-view-cohort'">My
				Cohort</p>
			<hr>
			<p class="myNavLink" onclick="location.href='/change-password'">Change
				Password</p>
			<p class="myNavLink" onclick="location.href='/my-profile'">My
				Profile</p>
		</div>

		<div class="text-center p-3 myFooter"
			style="background-color: rgba(0, 0, 0, 0.2);">
			<p class="mb-2">${cohort }</p>
		</div>
	</div>

	<div class="main px-4">
		<div class="text-right mt-2 mr-2">
			<span style="font-size: 15px" class="mr-2">Welcome
				${user.getFullName() }</span> <a href="/logout"><img
				src="/resources/img/logout.png" class="mt-1"
				style="width: 15px; height: 15px;"></a>
		</div>

		<p>
		<div class="text-right">
			<c:choose>
				<c:when test="${isPresent}">
					<button class="btn btn-secondary disabled btn-sm"
						data-toggle="tooltip" data-placement="top"
						title="You are marked present for today">Mark me Present</button>
				</c:when>
				<c:otherwise>
					<a href="/mark-present"><button class="btn btn-success btn-sm">Mark
							me Present</button></a>
				</c:otherwise>
			</c:choose>
		</div>

		<p class="cohort-label ml-3" style="font-size: 20px">Meetings</p>
		<div class="container-fluid py-2">
			<div
				class="d-flex flex-row flex-nowrap scrollmenu pt-2 pb-2 pl-2 pr-2">

				<c:forEach var="meeting" items="${myMeetings}">
					<div class="pt-1 px-1 mr-2 bg-white text-center rounded"
						style="width: 150px;">
						<img src="/resources/img/round-table.png"
							class="img-responsive mt-2" style="width: 40px; height: 40px;">
						<p style="font-size: 15px;" class="text-center mt-2">${meeting.getMeetingName() }</p>
						<button
							onclick="location.href='/view-cohort?cohortID=${meeting.getMeetingName()}'"
							class="btn btn-success btn-sm mb-3">Join Now</button>
					</div>
				</c:forEach>

			</div>
		</div>

		<p class="cohort-label ml-3" style="font-size: 20px">Surveys</p>
		<div class="container-fluid py-2">
			<div
				class="d-flex flex-row flex-nowrap scrollmenu pt-2 pb-2 pl-2 pr-2">

				<c:forEach var="survey" items="${allSurveys}">
					<div class="pt-1 px-1 mr-2 bg-white text-center rounded"
						style="width: 150px;" data-toggle="tooltip" data-placement="right"
						title="${survey.getSurveyName()}">
						<img src="/resources/img/round-table.png"
							class="img-responsive mt-2" style="width: 40px; height: 40px;">
						<p style="font-size: 15px;" class="text-center mt-2">${survey.getSurveyName().substring(0,10) }...</p>
						<button onclick="location.href='/view-survey/${survey.getId()}'"
							class="btn btn-success btn-sm mb-3">Open</button>
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