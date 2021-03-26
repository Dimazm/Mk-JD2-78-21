<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
  <head>
   Welcome to Messenger v1.0
  </head>
  <body>
    <p>Welcome <%= session.getAttribute("currentUser") %> !</p></br>
  </body>
</html>