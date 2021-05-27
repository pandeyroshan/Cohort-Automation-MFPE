<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Admin Dashboard - All Mentors</title>
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
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
            }
            .myFooter{
            height: 50px; 
            position: fixed; 
            bottom:0%;
            width:25%; 
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
            span{
            font-size: 20px;
            margin-right: 5px;
            }
            p.cohort-label{
            padding: 0;
            margin: 0;
            }
            .card-body {
            min-height: 300px;
            min-width: 300px;
            margin-right: 5px;
            }
            .main {
            overflow:   scroll;
            }
            ::-webkit-scrollbar {
            width: 0px;
            background: transparent;
            }
		    .myNavLink:hover{
		      font-weight: bold;
		      cursor: pointer;
		    }
        </style>
    </head>
    <body>
        <div class="sidenav">
            <div class="text-center">
                <img class="img-responsive mb-5" src="/resources/img/logo.png" style="width: 70%;">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control p-3" placeholder="Enter Keywords .." aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <span class="input-group-text" id="basic-addon2">&#128269;</span>
                    </div>
                </div>
            </div>
            <div class="text-left pl-5 pt-3 pr-5">
                <p class="myNavLink" onclick="location.href='/'">Homepage</p>
                <p class="myNavLink" onclick="location.href='/all-cohort'">Cohorts</p>
                <p class="myNavLink" onclick="location.href='/all-sme'">SMEs</p>
                <p class="myNavLink" ><strong>Mentors</strong></p>
                <p class="myNavLink" onclick="location.href='/all-coach'">Coaches</p>
                <p class="myNavLink" onclick="location.href='/all-trainer'">Trainer</p>
                <hr>
                <p class="myNavLink" onclick="location.href='/admin-change-password'">Change Password</p>
                <p class="myNavLink" >My Profile</p>
            </div>
            <div class="text-center p-3 myFooter" style="background-color: rgba(0, 0, 0, 0.2);">
                <p class="mb-2">Admin Dashboard</p>
            </div>
        </div>
        <div class="main px-4">
            <!-- user salutation -->
            <div class="text-right mt-3 mr-3">
                <span style="font-size: 15px" class="mr-2">Welcome admin</span>
                <img src="/resources/img/logout.png" class="mt-1" style="width: 15px; height: 15px;">
            </div>

            <!-- Breadcrumb -->
            <small class="font-weight-light text-secondary">
              <span style="font-size: 15px;">
                <a href="/">Home</a> /
              </span>
              <span style="font-size: 15px;">
                Mentors
              </span>
            </small>
            
            <div class="text-right mr-3">
                <a href="/create-mentor"><button class="btn btn-success btn-sm">Create Mentor</button></a>
            </div>
            <div class="row mt-4 ml-3">
              
              <c:forEach var="user" items="${allMentor}">
					<div class="pt-3 px-3 mr-3 mt-2 bg-secondary text-center rounded">
	                  <img src="/resources/img/profile-user.png" class="img-responsive" style="width: 50px; height: 50px;">
	                  <p style="font-size: 15px;" class="text-center mt-2">${user.getFullName()}</p>
	                  <button class="btn btn-success btn-sm mb-3" data-toggle="modal" data-target="#exampleModalCenter${user.getUsername()}">view profile</button>
	                  
	                  <div class="modal fade" id="exampleModalCenter${user.getUsername()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLongTitle">${user.getFullName()} - Mentor</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body text-center">
						      	<img src="/resources/img/profile-user.png" class="img-responsive mb-3" style="width: 100px; height: 100px;">
						      	<p style="font-size: 20px; margin:0; padding:0;">${user.getFullName()} (${user.getUsername()})</p>
						      	<p class="text-muted" style="font-size: 20px; margin:0; padding:0;">${user.getPersonalEmail()}</p>
						      	
						      	<p class="text-left text-success" style="font-size: 20px;">Cohorts</p>
						      	<c:forEach var="cohort" items="${user.getMyCohorts()}">
						      		<p class="text-left" style="font-size: 15px;">${cohort.getName() } <a href="" style="text-decoration: none;">&#8599;</a></p>
						      	</c:forEach>
						      	<hr>
						      </div>
						    </div>
						  </div>
					  </div>
	                </div>
			  </c:forEach>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>