<%@ page import="by.tms.lesson25and26.jspandservlets.User" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<p>Users from servlet:
<table border="1">
    <tr>
        <th>Имя</th>
        <th>Номер</th>
    </tr>
    <%
        Map<String, User> users = (Map<String, User>) application.getAttribute("users");
        for (Map.Entry<String, User> user: users.entrySet()) {
            out.print(
                    "<tr>" +
                            "<td>" + user.getValue().getName() + "</td>" +
                            "<td>" + user.getKey() + "</td>" +
                            "</tr>");
        }
    %>
</table>
</p>
<a href="/jsp/save.jsp">Add new user</a></br>
<a href="/jsp/delete.jsp">Delete user from list</a>
</body>
</html>
