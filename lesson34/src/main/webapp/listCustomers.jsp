<%@ page import="by.tms.lesson34.services.UserService" %>
<%@ page import="by.tms.lesson34.entities.User" %>
<%@ page import="java.util.List" %>
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
        <th scope="col">Id</th>
        <th scope="col">Логин</th>
        <th scope="col">Пароль</th>
        <th scope="col">Роль</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td scope="row">${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
<div style="text-align: center;">
    <a href="adminPage.jsp">Главная страница администратора</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
