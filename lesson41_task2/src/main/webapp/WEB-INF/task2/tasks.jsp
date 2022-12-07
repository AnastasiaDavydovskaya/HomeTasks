<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task list</title>
    <jsp:include page="parts/bootstrap.jsp"/>
</head>
<body>
<div class="container">
    <div class="h5">Tasks:</div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Status</th>
            <th scope="col">Delete</th>
            <th scope="col">Progress in task</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td><a href="tasks/delete/${task.description}" class="btn btn-danger btn-sm rounded-0" type="button"
                       data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></a></td>
                <td><a href="tasks/update/${task.description}" class="btn btn-danger btn-sm rounded-0" type="button"
                       data-toggle="tooltip" data-placement="top" title="Update"><i class="fa fa-refresh"></i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div align="center">
    <a href="add">Добавить задачу</a>
    <br>
</div>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>