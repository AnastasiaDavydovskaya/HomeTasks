<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ошибка</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<c:choose>
    <c:when test="${result eq 'SUCCESS_DELETE'}">
        <h1 class="alert alert-success">User was deleted</h1>
    </c:when>
    <c:when test="${result eq 'SUCCESS_UPDATE'}">
        <h1 class="alert alert-success">User was updated</h1>
    </c:when>
    <c:when test="${result eq 'SUCCESS_SAVE'}">
        <h1 class="alert alert-success">User was saved</h1>
    </c:when>
    <c:when test="${result eq 'NOT_FOUND'}">
        <h1 class="alert alert-warning">User not found</h1>
    </c:when>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>