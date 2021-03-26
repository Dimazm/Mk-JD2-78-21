<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
  <head>
   Welcome to Messenger v1.0
  </head>
  <body>
    <p>Welcome <%= session.getAttribute("currentUser") %> !</p></br>
    <p><a href="InChat">Open Chat</a></p>
	<p><a href="Hist">Open History</a></p>
	<p><a href="addUser">Start Page</a></p>
  </body>
</html>