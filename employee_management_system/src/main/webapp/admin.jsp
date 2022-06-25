<%@ page import="entity.DepartmentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.DepartmentDao" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/15/2022
  Time: 9:43 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Regulation Management</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="center">
<h1>Admin Regulation Management</h1>
<h3>Existing Regulations</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach items="${requestScope.allRegulations}" var="regulation">
        <tr>
            <td><a href="RegulationServlet?regulation=${regulation.id}">${regulation.id}</a></td>
            <td>${regulation.description}</td>
            <td>${regulation.department.name}</td>
        </tr>
    </core:forEach>
    </tbody>
</table>
<h3>New Regulation</h3>
<form action="RegulationServlet" method="post">
    <label>Description:</label>
    <textarea name="description" cols="44" rows="10"></textarea>
    <label>Department:</label>
    <select name="department">
        <core:forEach items="${requestScope.allDepartments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </core:forEach>
    </select><br>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
</body>
</html>
