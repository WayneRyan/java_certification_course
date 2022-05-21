<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/21/2022
  Time: 10:16 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login Page</h2>
<form action="LoginController" method="post">
    <label>Email</label><input type="email" name="email"><br>
    <label>Password</label><input type="password" name="password"><br>
    <input type="submit" value="submit">
    <input type="reset" value="reset">
</form>
</body>
</html>
