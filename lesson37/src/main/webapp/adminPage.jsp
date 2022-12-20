<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница администратора</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body style="background-color: lightblue">
<div style="text-align: center; margin-top: 10%">
    <form action="listCustomers.jsp">
        <button class="btn btn-primary btn-lg btn-block">Список покупателей</button>
    </form> <br>
    <form action="deleteCustomer.jsp">
        <button class="btn btn-primary btn-lg btn-block">Удалить покупателя</button>
    </form> <br>
    <form action="updateCustomer.jsp">
        <button class="btn btn-primary btn-lg btn-block">Обновить покупателя</button>
    </form> <br>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>