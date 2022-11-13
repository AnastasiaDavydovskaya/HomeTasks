<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Зарегистрироваться</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="/save/person" method="POST">
    <div style="text-align: center;">
        <h1>Добро пожаловать!</h1>
        <h3>Зарегистрируйтесь в системе!</h3>
    </div>
    <div class="container">
        <div class="container-class">
            <div class="mb-3">
                <label class="form-label">Почта</label>
                <input type="email" class="form-control" name = "email">
            </div>
            <div class="mb-3">
                <label class="form-label">Пароль</label>
                <input type="password" class="form-control" name = "password">
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </div>
    </div>
</form>
<div style="text-align: center;">
    <a href="index.jsp">Войти в существующий аккаунт</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>