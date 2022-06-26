<%@ page import="entity.RegulationEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/15/2022
  Time: 9:44 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Regulation Management</title>
    <link rel="stylesheet" href="css/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#description').val('<%= request.getAttribute("initialComment")%>');
            $("#regulationSelect").change(function () {
                $.ajax({
                    url: "CommentServlet",
                    data: {
                        'regulationID': $('#regulationSelect :selected').text()
                    },
                    success: function (result) {
                        console.log(result);
                        $('#description').val(result);
                    },
                    error: function (result) {
                        console.log(result);
                    }
                });
            });
        });
    </script>
</head>
<body class="center">
<h1><a href="index.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i></a> User Regulation Management</h1>
<h3>Your Regulations</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach items="${requestScope.userRegulations}" var="regulation">
        <tr>
            <td>${regulation.id}</td>
            <td>${regulation.description}</td>
        </tr>
    </core:forEach>
    </tbody>
</table>
<h3>Make Comment</h3>
<form action="CommentServlet" method="post">
    <label>Description:</label>
    <textarea id="description" name="description" cols="44" rows="10"></textarea>
    <label>Regulation:</label>
    <select name="regulation" id="regulationSelect">
        <core:forEach items="${requestScope.userRegulations}" var="regulation">
            <option value="${regulation.id}">${regulation.id}</option>
        </core:forEach>
    </select><br>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
</body>
</html>
