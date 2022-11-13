<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновить покупателя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<form action="/list/update" method="POST">
    Login to update:</br><input type="email" class="form-control" name="to-update"></br>
    New login:</br><input type="email" class="form-control" name="login-to-update"></br>
    New password:</br><input type="password" class="form-control" name="password-to-update"></br>
    <input type="submit" class="btn btn-primary" value="Submit"></br>
</form>
<a href="listCustomers.jsp">See list customers</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>