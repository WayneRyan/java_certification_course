<%@ page import="entity.DepartmentEntity" %><%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/15/2022
  Time: 9:43 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Regulation Management</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="center">
<%
    List<DepartmentEntity> allDepartments = DepartmentDao.getAllDepartments();
%>
<h1>Admin Regulation Management</h1>
<h3>New Regulation</h3>
<form action="RegulationServlet" method="post">
    <label>Description</label>
    <textarea name="description" cols="44" rows="10"></textarea>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
</body>
</html>
