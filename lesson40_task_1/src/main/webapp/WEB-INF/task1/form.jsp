<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<form:form action="students" method="POST" modelAttribute="student">
    <div>
        <table>
            <tr>
                <td>First name</td>
                <td><form:input path="firstName" type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><form:input path="lastName" type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td>Number of group</td>
                <td><form:input path="numberOfGroup" type="text" name="numberOfGroup"/></td>
            </tr>
            <tr>
                <td>GPA</td>
                <td><form:input path="GPA" type="text" name="GPA"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>