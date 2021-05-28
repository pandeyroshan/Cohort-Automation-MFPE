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
		<div class="text-right">
			<%
				if(user.isAdmin()){
					out.print("<button class=\"btn btn-success mr-3\" data-toggle=\"modal\" data-target=\"#exampleModal\">Edit</button>");
					out.print("<button onclick=\"location.href='/delete-cohort?cohortId=${cohort.getName()}'\" class=\"btn btn-danger\">Delete</button>");
				} else if(user.isSME()){
					out.print("<button data-toggle=\"modal\" data-target=\"#createMeetingModal\" class=\"btn btn-success btn-sm mr-3\">Create Meeting</button>");
				} else if(user.isMentor()){
					out.print("<button data-toggle=\"modal\" data-target=\"#createMeetingModal\" class=\"btn btn-success btn-sm mr-3\">Create Meeting</button>");
				} else if(user.isCoach()){
					out.print("<button data-toggle=\"modal\" data-target=\"#createMeetingModal\" class=\"btn btn-success btn-sm mr-3\">Create Meeting</button>");
					out.print("<button data-toggle=\"modal\" data-target=\"#addMemberModal\" class=\"btn btn-success btn-sm\">Add Members</button>");
				} else if(user.isTrainer()){
					out.print("<button data-toggle=\"modal\" data-target=\"#createMeetingModal\" class=\"btn btn-success btn-sm mr-3\">Create Meeting</button>");
				}
			%>

			<!-- Edit Cohort Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Edit
								${cohort.getName() }</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-left">
							<form method="post" action="/edit-cohort">
								<input type="hidden" name="oldCohortId"
									value=${cohort.getName() }> <label
									style="font-size: 15px;">Cohort Code</label> <input type="text"
									class="form-control" name="cohortCode"
									placeholder="Provide a cohort Code" value=${cohort.getName() }>

								<label style="font-size: 15px;">Cohort Description</label> <input
									type="text" class="form-control" name="cohortDesc"
									placeholder="Provide a cohort Description ex - Advance Java Track"
									value=${cohort.getDescription() }> <label
									style="font-size: 15px;">Start Date</label> <input type="date"
									class="form-control" name="startDate"> <label
									style="font-size: 15px;">Total Weeks</label> <input
									type="number" class="form-control" name="totalWeeks"
									placeholder="Provide number of weeks"> <label
									for="exampleInputEmail1" style="font-size: 15px;">Trainer</label>
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
									<button type="submit" class="btn btn-success">Update
										Cohort</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>


			<!-- Create Meeting Modal -->
			<div class="modal fade" id="createMeetingModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Create
								Meeting - ${cohort.getName() }</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-left">
							<form method="post" action="/create-meeting">
								<input type="hidden" name="CohortId" value=${cohort.getName() }>
								<input type="hidden" name="username"
									value=${user.getUsername() }> <label
									style="font-size: 15px;">Meeting name</label> <input
									type="text" class="form-control" name="meetingName"
									placeholder="Meeting Name"> <label
									style="font-size: 15px;">Meeting start time</label> <input
									type="datetime-local" class="form-control" name="startDateTime">

								<label style="font-size: 15px;">Meeting end time</label> <input
									type="datetime-local" class="form-control" name="endDateTime">

								<label style="font-size: 15px;">Meeting link</label> <input
									type="url" class="form-control" name="meetingLink">


								<hr>
								<div class="text-right mt-3">
									<button type="submit" class="btn btn-success">Create
										Meeting</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- Add member Modal -->
			<div class="modal fade" id="addMemberModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Member
								${cohort.getName() }</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-left">
							<form method="post" action="/add-member">
								<input type="hidden" name="cohortID" value=${cohort.getName() }>
								<label for="exampleInputEmail1" style="font-size: 15px;">Employee
									ID</label> <input type="number" class="form-control" name="empID"
									placeholder="Enter Employee ID" required> <label
									for="exampleInputEmail1" style="font-size: 15px;">First
									Name</label> <input type="text" class="form-control" name="fname"
									placeholder="Enter First Name" required> <label
									for="exampleInputEmail1" style="font-size: 15px;">Last
									Name</label> <input type="text" class="form-control" name="lname"
									placeholder="Enter Last Name" required> <label
									for="exampleInputEmail1" style="font-size: 15px;">Email
									Address</label> <input type="email" class="form-control" name="email"
									placeholder="Enter Email address" required>

								<div class="text-right mt-3">
									<button type="submit" class="btn btn-primary">Add
										Member</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Show basic information -->
		<small class="" style="font-size: 15px;">
			<p style="margin: 0; padding: 0;">${cohort.getName() }-
				${cohort.getDescription() }</p>
			<p style="margin: 0; padding: 0;">Cohort Start Date -
				${cohort.getStartdate() }</p>
		</small>
		<hr>


		<!-- Show SME, Mentor, Coach and Trainer -->
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

		<br>

		<p style="font-size: 15px; margin: 0; padding: 0;" class="ml-3">Members</p>
		<div class="container-fluid py-2">
			<div
				class="d-flex flex-row flex-nowrap scrollmenu pt-2 pb-2 pl-2 pr-3">
				
				<c:forEach var="user" items="${allMembers}">
		            <div class="pt-2 px-2 mr-2 bg-white text-center rounded">
		              <img src="/resources/img/profile-user.png"
							class="img-responsive" style="width: 50px; height: 50px;">
		              <p style="font-size: 15px;" class="text-center mt-2">${user.getFullName() }</p>
		              <button onclick="location.href=''"
							class="btn btn-success btn-sm mb-3">view profile</button>
		            </div>
	            
			</c:forEach>

		</div>
      	</div>
      	
      	<hr>
      	
		<p class="text-center text-success" style="font-size: 20px;">Meetings</p>
		<table class="table table-striped" style="font-size: 15px;">
			<thead>
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Name</th>
					<th scope="col">Start Time</th>
					<th scope="col">End Time</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="meeting" items="${allMeetings}" varStatus="theCount">
					<tr>
						<td>${theCount.count}</td>
						<td>${meeting.getMeetingName() }</td>
						<td>${meeting.getStartDateTime() }</td>
						<td>${meeting.getEndDateTime() }</td>
						<%
							Meeting meeting = (Meeting) pageContext.getAttribute("meeting");
							
							if(meeting.getCreatedBy().equals(user.getUsername())){
								out.print("<td><a data-toggle=\"modal\" data-target=\"#viewMeetingModal"+meeting.getId()+"\" >View</a> | <a href=\"/delete-meeting?meetingId="+meeting.getId()+"&cohortId="+meeting.getCohortID()+"\">Delete</a></td>");
							} else{
								out.print("<td><a target=\"_blank\" href="+meeting.getMeetingURL()+">Join now</a></td>");
							}
						%>
						
						<div class="modal fade" id="viewMeetingModal${meeting.getId() }" tabindex="-1" role="dialog" aria-labelledby="viewMeetingModal${meeting.getId() }" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											Meeting - ${meeting.getMeetingName() }</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body text-left">
										<small style="font-size: 15px; margin:0; padding:0;">
											<p>Start Time - ${meeting.getStartDateTime() }</p>
											<p>End Time - ${meeting.getEndDateTime() }</p>
											<p>Joining Link - ${meeting.getMeetingURL() } - <a target="_blank" href=${meeting.getMeetingURL() }>Click here to join</a></p>
										</small>
									</div>
								</div>
							</div>
						</div>
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