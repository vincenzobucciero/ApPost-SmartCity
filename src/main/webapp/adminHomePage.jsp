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
    <title>ApPost-Home Page</title>
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
                <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Masthead-->
<header class="masthead">

    <!--Card di sfondo per i parcheggi-->
    <!--<div class="my-5 card text-light mx-auto" style="width: 70rem;
                background: linear-gradient(to bottom, rgba(92, 77, 66, 0.8) 0%, rgba(92, 77, 66, 0.8) 80%), url('img/imgCard/CardAdmin.jpg'); background-size: cover;">
        <div class="card-title">
            <h3 style="font-weight:bold; text-align:left;">
                Qui puoi visualizzare i tuoi parcheggi:
            </h3>
        </div>-->
    <div class="my-5 card text-black mx-auto" style="width: 70rem">
        <div class="row"> <!-- Inizio Card-->
            <c:forEach items="${list}" var="record"> <!--Ciclo FOR -->
                <div class="my-4 card bg-light mx-auto" style="width: 20rem;">
                    <div class="card-body">
                        <p class="text-muted mb-0 fs-3">
                        <td>
                                ${record.getNomeParcheggio()}
                        </td>
                        <hr class="text-black">
                        </p><!-- Fine Nome Parcheggio-->
                        <h5 class="card-text-">
                            <p class="text-black">
                            <td>
                                    ${record.getIndirizzo()}<br>
                                Numero Posti Auto: ${record.getPostiAuto()}<br>
                                Numero Posti Furgone: ${record.getPostiFurgone()}<br>
                                Numero Posti Moto: ${record.getPostiMoto()}<br>

                            </td>
                            </p>
                        </h5> <!-- Fine Indirizzo&NumPosti-->
                        <div>
                            <form action="InfoParkingServlet" method="post">
                                <input type="hidden" name="idparking" value="${record.getIdParcheggio()}">

                                <div class="text-center">
                                    <button type="submit" class="btn btn-outline-primary">Modifica</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div><!-- Fine Card-->
            </c:forEach>
        </div>
    </div>
    </div><!-- FINE SEZIONE CARD-->


    <div class="my-5 card text-black mx-auto" style="width: 60rem">
        <div class="card-title">
            <h4 style="font-weight:bold; text-align:left;">
                Qui puoi visualizzare le statistiche:
            </h4>
        </div>
    </div>
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