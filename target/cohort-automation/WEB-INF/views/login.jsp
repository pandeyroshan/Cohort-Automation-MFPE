<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>CA - Login Page</title>
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
      </div>

      <div class="mt-5 text-center">
        <img src="/resources/img/user.png" class="mb-3" style="width: 100px; height: 100px;">
        <p>Login here to proceed further  &#8594;</p>
      </div>

      <div class="text-center p-3 myFooter" style="background-color: rgba(0, 0, 0, 0.2);">
        <p class="mb-2 title">Cohort Automation</p>
      </div>
    </div>

    <div class="main p-5">
      <h1 class="font-weight-light text-center mt-5">LOGIN PAGE</h1>
      <div class="p-5 mt-3" style="background-color: #C4C4C4;">
        <form method="post">
            <label for="exampleInputEmail1" style="font-size: 15px;">Username</label>
            <input type="text" class="form-control" name="username" placeholder="Username">

            <label for="exampleInputEmail1" style="font-size: 15px;">New Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password">
            
            <div class="text-center mt-3">
                <button type="submit" class="btn btn-primary">Login Now</button>
            </div>
        </form>
      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  </body>
</html>