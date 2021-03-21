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
 <form method="POST" name="authorization" action="http://example.com/profile.php">
     Логин: <input type="text" name="username"><br>
     Пароль: <input type="password" name="user_password"><br>
     <input type="submit" value="Войти">
 </form>
  </form>
 </body>
</html>