<%@ page import="java.util.List" %>
<%@ page import="by.tms.lesson25and26.jspandservlets.User" %>
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
        for (User user : (List<User>) application.getAttribute("users")) {
            out.print(
                    "<tr>" +
                            "<td>" + user.getName() + "</td>" +
                            "<td>" + user.getNumber() + "</td>" +
                            "</tr>");
        }
    %>
</table>
</p>
<a href="/jsp/save.jsp">Add new user</a></br>
<a href="/jsp/delete.jsp">Delete user from list</a>
</body>
</html>
