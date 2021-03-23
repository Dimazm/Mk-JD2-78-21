<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%!
    String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");
        return sdf.format(new Date());
}
%>
<html>
 <head>
   <title>!DOCTYPE</title>
   <meta charset="utf-8">
 </head>
 <body>
 <p><%= getFormattedDate() %></p>
  <form method="GET" action="signUp">
      <TABLE   WIDTH=300 ALIGN=left BORDER=2 BGCOLOR=lightgrey CELLPADDING=10 CELLSPACING=2>
            <tr>
      			<td>First Name: </td>
      			<td><input type="text" name="firstName" /></td>
      			<p>
      			<input type="button" onclick="location.href='//Mk-JD2-78-21-1.0.0-SNAPSHOT/hello';" value="index">
      			</p>
            </tr>
      		<tr>
      			<td>Last Name: </td>
      			<td><input type="text" name="lastName" /></td>
      		</tr>
      		<tr>
      			<td>Middle Name: </td>
      			<td><input type="text" name="middleName" /></td>
      		</tr>
      		<tr>
      			<td>Date of Birth:</td>
      			<td> <input type="date" name="date" /></td>
      		</tr>
      		<tr>
      			<td>login: </td>
      			<td><input type="text" name="login" /></td>
      		</tr>
      		<tr>
      			<td>Password:</td>
      			<td><input type="password" name="password" /></td>
      		</tr>
      		<tr>
      		<td BGCOLOR=white></td>
      			<td align=right BGCOLOR=lightblue><input type="submit" value="Submit"></td>
      		</tr>
  </form>
 </body>
</html>