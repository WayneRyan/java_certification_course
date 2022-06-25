<%@ page import="entity.RegulationEntity" %>
<%@ page import="entity.CommentEntity" %>
<%@ page import="entity.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/16/2022
  Time: 6:13 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regulation Details</title>
    <link rel="stylesheet" href="css/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
    <%
        RegulationEntity regulation = (RegulationEntity) request.getAttribute("regulation");
    %>
</head>
<body class="center">
<h1><a href="LoginServlet"><i class="fa-solid fa-house"></i></a>Regulation Details</h1>
<ul>
    <li>ID: <%= regulation.getId()%>
    </li>
    <li>Description: <%= regulation.getDescription()%>
    </li>
    <li>Department Name: <%= regulation.getDepartment().getName()%><br>Department Members:
        <ul>
            <% for (UserEntity user : regulation.getDepartment().getUsers()) { %>
            <li><%= user.getUserName()%>
            </li>
            <% } %>
        </ul>
    </li>
</ul>
<h1>Regulation Comments</h1>
<table>
    <tr>
        <th>Description:</th>
        <th>User:</th>
    </tr>
    <% for (CommentEntity comment : regulation.getComments()) { %>
    <tr>
        <td><%= comment.getDescription() %>
        </td>
        <td><%= comment.getUser().getUserName() %>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
