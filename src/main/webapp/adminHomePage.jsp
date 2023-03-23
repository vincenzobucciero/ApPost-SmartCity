<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ApPost-Smart Parking</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/iconMoney.png" />
    <link rel="icon" type="image/x-icon" href="img/wallpaperCar.jpg" />
    <!-- Bootstrap Icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
    <!-- SimpleLightbox plugin CSS-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="img">
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="index.jsp">ApPost</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link" href="adminHomePage.jsp">Torna alla home</a></li>
                <li class="nav-item"><a class="nav-link" href="index.jsp  ">Esci</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Masthead-->
<header class="masthead">

    <div class="row">
        <div class="col-lg-7">
            <div class="card mb-4">
                <div class="card-body">
                    <h3 class="card-title">Informazioni Parcheggi</h3>
                    <div class="row">
                        <div class="col-sm-5">
                            <h4 class="mb-2">Nome Parcheggio</h4> <!--Nome Parcheggio -->
                            <!--Qui devi fare la stampa per il nome -->
                            <p>......</p>
                        </div>
                        <hr>
                        <div class="col-sm-5"><!--Indirizzo Parcheggio -->
                            <h4 class="mb-0">Indirizzo Parcheggio</h4>
                            <!--Qui devi fare la stampa per l'indirizzo -->
                            <p>......</p>
                        </div>
                        <hr>
                        <div class="col-sm-5"><!--Posti parcheggio -->
                            <h4 class="mb-0">Numero Posti</h4>
                            <!--Qui devi fare la stampa per i posti -->
                            <p>......</p>
                        </div>
                        <hr>
                        <div class="col-sm-5"><!--Id Parcheggio -->
                            <h4 class="mb-0">Id Parcheggio</h4>
                            <!--Qui devi fare la stampa per l'Id -->
                            <p>......</p>
                        </div>
                        <hr>

                    </div>


                </div>
                <hr>
            </div>
        </div>
    </div>
    </div> <!--Fine CARD INFO -->



    <!-- <h3>Sono un admin</h3>
        Stampo tutti i nomi dei parcheggi
        <c:forEach items="${list}" var="record">
            <tr>
                <td>${record.getNomeParcheggio()}</td><br>
            </tr>
        </c:forEach> -->
</header>


<!-- Footer-->
<footer class="bg-light py-5">
    <div class="container px-4 px-lg-5"><div class="small text-center text-muted">Copyright &copy; 2022 - Company Name</div></div>
</footer>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>


</body>
</html>