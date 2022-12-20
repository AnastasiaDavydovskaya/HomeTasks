<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Войти</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="/enter" method="POST">
    <div style="text-align: center;">
        <h1>Добро пожаловать!</h1>
        <h3>Войдите в систему!</h3>
    </div>
    <div class="container">
        <div class="container-class">
            <div class="mb-3">
                <label class="form-label">Почта</label>
                <input name = "email" type="email" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Пароль</label>
                <input name="password" type="password" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Войти</button>
        </div>
    </div>
</form>
<div style="text-align: center;">
    <a href="registration.jsp">Зарегистрироваться в системе</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>