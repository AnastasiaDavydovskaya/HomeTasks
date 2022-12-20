<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees List</title>
    <jsp:include page="parts/bootstrap.jsp"/>
</head>
<body>

<c:if test="${students eq null or empty students}">
    <c:redirect url="form"/>
</c:if>

<div class="container">
    <div class="h5">Students:</div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">Number of group</th>
            <th scope="col">GPA</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.numberOfGroup}</td>
                <td>${student.GPA}</td>
                <td><a href="students/delete/${student.id}" class="btn btn-danger btn-sm rounded-0" type="button"
                       data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<jsp:include page="parts/footer.jsp"/>
</html>