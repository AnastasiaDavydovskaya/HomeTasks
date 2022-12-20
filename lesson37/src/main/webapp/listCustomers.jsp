<%@ page import="by.tms.lesson37.entities.User" %>
<%@ page import="by.tms.lesson37.services.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список покупателей</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div style="align-items: center">
    <p>Customers:</p>
</div>
<table class="table table-hover">
    <tr>
        <th scope="col">Логин</th>
        <th scope="col">Пароль</th>
    </tr>

    <%
        for (User user : new UserService().getUsers()) {
            out.print(
                    "<tr>" +
                            "<td scope=\"row\">" + user.getLogin() + "</td>" +
                            "<td>" + user.getPassword() + "</td>" +
                            "</tr>");
        }
    %>

</table>
<div style="text-align: center;">
    <a href="adminPage.jsp">Главная страница администратора</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
