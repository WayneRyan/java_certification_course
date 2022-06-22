<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/15/2022
  Time: 9:44 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Regulation Management</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="center">
<h1>User Regulation Management</h1>
<h3>Your Regulations</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach items="${requestScope.userRegulations}" var="regulation">
        <tr>
            <td>${regulation.id}</td>
            <td>${regulation.description}</td>
            <td>${regulation.department.name}</td>
        </tr>
    </core:forEach>
    </tbody>
</table>
</body>
</html>
