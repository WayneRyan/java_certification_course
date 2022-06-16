<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="center">
<%
    session.invalidate();
%>
<form action="LoginServlet" method="post">
    <label>User Name</label><input type="text" name="userName"/><br>
    <label>Password</label><input type="password" name="password"/><br>
    <input type="submit" value="submit">
    <input type="reset">
</form>
</body>
</html>