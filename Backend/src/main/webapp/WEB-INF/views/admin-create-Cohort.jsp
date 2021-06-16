<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Admin - Create Cohort</title>
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
      .cohortClass{
        cursor: pointer;
        border: solid;
        border-color: #C4C4C4;
      }
      .cohortClass:hover{
        border-color: #fff;
      }
      a{
        text-decoration: none;

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
        <p class="myNavLink" onclick="location.href='/all-cohort'"><strong>Cohorts</strong></p>
        <p class="myNavLink" onclick="location.href='/all-sme'">SMEs</p>
        <p class="myNavLink" onclick="location.href='/all-mentor'">Mentors</p>
        <p class="myNavLink" onclick="location.href='/all-coach'">Coaches</p>
        <p class="myNavLink" onclick="location.href='/all-trainer'">Trainer</p>
        <hr>
        <p class="myNavLink">Change Password</p>
        <p class="myNavLink">My Profile</p>
      </div>

      <div class="text-center p-3 myFooter" style="background-color: rgba(0, 0, 0, 0.2);">
        <p class="mb-2">Admin Dashboard</p>
      </div>
    </div>

    <div class="main px-4">
      <div class="text-right mt-2 mr-2">
        <span style="font-size: 15px" class="mr-2">Welcome admin</span>
        <a href="/logout"><img src="/resources/img/logout.png" class="mt-1" style="width: 15px; height: 15px;"></a>
      </div>
      
      <!-- Breadcrumb -->
      <small class="font-weight-light text-secondary">
        <span style="font-size: 15px;">
          <a href="/">Home</a> /
        </span>
        <span style="font-size: 15px;">
          <a href="/all-cohort">cohort</a> /
        </span>
        <span style="font-size: 15px;">
          create cohort
        </span>
      </small>
      
      <div class="p-5 mt-3" style="background-color: #C4C4C4;">
                <form method="post">
                    <label style="font-size: 15px;">Cohort Code</label>
                    <input type="text" class="form-control" name="cohortCode" placeholder="Provide a cohort Code">
                    
                    <label style="font-size: 15px;">Cohort Description</label>
                    <input type="text" class="form-control" name="cohortDesc" placeholder="Provide a cohort Description ex - Advance Java Track">

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
                        <a href="/create-trainer"><button type="button" class="btn btn-primary ml-1" style="white-space: nowrap; text-align: center;">Create New</button></a>
                    </div>

                    <label for="exampleInputEmail1" style="font-size: 15px;">Coach</label>
                    <div class="d-flex">
                        <select class="form-control" name="coachID">
                          <c:forEach var="coach" items="${allCoach}">
                          	<option value="${coach.getUsername() }">${coach.getFullName()}</option>
                          </c:forEach>
                        </select>
                        <a href="/create-coach"><button type="button" class="btn btn-primary ml-1" style="white-space: nowrap; text-align: center;">Create New</button></a>
                    </div>

                    <label for="exampleInputEmail1" style="font-size: 15px;">Mentor</label>
                    <div class="d-flex">
                        <select class="form-control" name="mentorID">
                          <c:forEach var="mentor" items="${allMentor}">
                          	<option value="${mentor.getUsername() }">${mentor.getFullName()}</option>
                          </c:forEach>
                        </select>
                        <a href="/create-mentor"><button type="button" class="btn btn-primary ml-1" style="white-space: nowrap; text-align: center;">Create New</button></a>
                    </div>

                    <label for="exampleInputEmail1" style="font-size: 15px;">SMEs</label>
                    <div class="d-flex">
                        <select class="form-control" name="smeID">
                          <c:forEach var="sme" items="${allSME}">
                          	<option value="${sme.getUsername() }">${sme.getFullName()}</option>
                          </c:forEach>
                        </select>
                        <a href="/create-sme"><button type="button" class="btn btn-primary ml-1" style="white-space: nowrap; text-align: center;">Create New</button></a>
                    </div>
                    <hr>
                    <div class="text-right mt-3">
                        <button type="submit" class="btn btn-success">Create Cohort</button>
                    </div>
                </form>
            </div>
	
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  </body>
</html>