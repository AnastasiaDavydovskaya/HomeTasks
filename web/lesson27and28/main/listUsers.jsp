<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<c:if test="${users eq null or empty users}">
    <c:redirect url="/lesson27and28/exception/exception.jsp"/>
</c:if>

<div class="container">
    <h1 style="text-align: center"><span class="badge text-bg-info">Course information</span></h1>
    <div class="h5" style="text-align: center">Students:</div>
    <table class="table">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Number</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <c:if test="${user.role eq 'STUDENT'}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.number}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>

<div class="container">
    <c:forEach var="user" items="${users}">
        <c:if test="${user.role ne 'STUDENT'}">
            <div class="card m-3">
                <div class="card-body">
                    <c:choose>
                        <c:when test="${user.role eq 'TEACHER'}">
                            <h5 class="card-title">Teacher</h5>
                            <p class="card-text">Name: ${user.name} ${user.number}</p>
                        </c:when>
                        <c:when test="${user.role eq 'ADMIN'}">
                            <h5 class="card-title">Admin</h5>
                            <p class="card-text">Name: ${user.name} ${user.number}</p>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>

<p style="text-align: center">
    <a href="/lesson27and28/main/form.jsp">Add new student</a></br>
    <a href="/lesson27and28/main/deleteUser.jsp">Delete student</a></br>
    <a href="/lesson27and28/main/updateUser.jsp">Update student</a></br>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
