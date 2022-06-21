<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><% out.println("<br/> This is JSP Page");

 Object obj = session.getAttribute("obj");
 out.println("<br/> Value of obj is: " + obj);
 Object obj2 = application.getAttribute("obj2");
 out.println("<br/> Value of obj is: " + obj2);
%>
</body>
</html>