<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Магазин</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Меню</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Каталог</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Цены</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Наши магазины
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Минск</a></li>
                        <li><a class="dropdown-item" href="#">Гродно</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Доставка</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Поиск" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Поиск</button>
            </form>
        </div>
    </div>
</nav>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" style="height: 400px">
            <img src="${pageContext.request.contextPath}/images/cosmetics-1.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Наша продукция</h5>
                <p>Работы наших высокопрофессиональных мастеров</p>
                <button type="button" class="btn btn-secondary btn-lg">Просмотреть каталог</button>
            </div>
        </div>
        <div class="carousel-item" style="height: 400px">
            <img src="${pageContext.request.contextPath}/images/cosmetics-2.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item" style="height: 400px">
            <img src="${pageContext.request.contextPath}/images/cosmetics-3.jpg" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</br>
</br>
</br>
<div class="container text-center">
    <div class="row">
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <img src="${pageContext.request.contextPath}/images/cosmetics-1.jpg" class="card-img-top" style="border-radius: 50%" alt="...">
                <div class="card-body">
                    <h4>Австрийская косметика</h4>
                    <p class="card-text">Австрия познакомилась с косметикой в 19 веке и незаметно для себя стала лидером
                        по производству этого продукта. Первым на поприще изготовления прославился Франц Захер. </p>
                </div>
            </div>
        </div>
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <img src="${pageContext.request.contextPath}/images/cosmetics-2.jpg" class="card-img-top" style="border-radius: 50%" alt="...">
                <div class="card-body">
                    <h4>Швейцарская косметика</h4>
                    <p class="card-text">Популярность этой косметики не знает границ. Благодаря высоким стандартам
                        производства и использованию только натуральных ингредиентов, швейцарская косметика заработала себе
                        международную репутацию качества.</p>
                </div>
            </div>
        </div>
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <img src="${pageContext.request.contextPath}/images/cosmetics-3.jpg" class="card-img-top" style="border-radius: 50%" alt="...">
                <div class="card-body">
                    <h4>Немецкая косметика</h4>
                    <p class="card-text">Косметика в Германии популярена не меньше, чем пиво и сосиски. Страна занимает
                        третье место в мировом рейтинге по производству люксовой косметики.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>