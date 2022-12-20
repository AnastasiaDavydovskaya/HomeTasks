<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление покупателя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<form action="/system_delete" method="POST">
    Login to delete:</br><input type="email" name="to-delete" class="form-control"></br>
    <input type="submit" value="Submit" class="btn btn-primary"></br>
</form>
<a href="listCustomers.jsp">Список покупателей</a>
</body>
</html>
