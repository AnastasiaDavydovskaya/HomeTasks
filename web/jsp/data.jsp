<%@ page import="by.tms.lesson25and26.jspandservlets.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<p>Current user from servlet:
<table border="1">
    <tr>
        <th>Имя</th>
        <th>Номер</th>
    </tr>
    <%
        User user = (User) request.getAttribute("user");
        out.print("<tr>" +
                "<td>" + user.getName() + "</td>" +
                "<td>" + user.getNumber() + "</td>" +
                "</tr>");
    %>
</table>
</p>
<a href="/jsp/list.jsp">See list users</a>
<a href="/jsp/delete.jsp">Delete user from list</a>
</body>
</html>
