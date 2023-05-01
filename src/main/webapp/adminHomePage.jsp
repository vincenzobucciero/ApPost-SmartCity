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
    <!-- Bootstrap Icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- SimpleLightbox plugin CSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="css/styleAdmin.css">
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
                <li class="nav-item"><a class="nav-link" href="homepage">Torna alla home</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead">

    <div class="col-lg-10 mx-auto mb-4">
        <h2 class="text-center mt-0" style="color: white">Gestione</h2>
        <hr class="divider" />
    </div>
    <!--INIZIO SEZIONE CARD-->
    <div class="row" style="padding: 4rem">
        <!-- Inizio Prima Card-->
        <div class="my-3 card bg-light" style="width: 20rem;">
            <img src="img/park2.jpg">
            <div class="card-body">
                <h4 class="card-title">Parcheggi</h4>
                <p class="card-text">Viene visualizzata la lista dei parcheggi con le proprie informazioni.</p>
                <form action="ShowParkingServlet" method="post">
                    <button class="btn btn-primary text-center">Visualizza parcheggi</button>
                </form>
            </div>
        </div><!-- Fine Prima Card-->

        <!-- Inizio Seconda Card-->
        <div class="my-3 card bg-light mx-auto" style="width: 20rem;">
            <img src="img/statistiche.jpg">
            <div class="card-body">
                <h4 class="card-title">Statistiche</h4>
                <p class="card-text">Potrai vedere le statistiche relative a ogni mese e per ogni parcheggio </p>
                <a href="statistiche.jsp" class="btn btn-primary text-center">Visualizza statistiche</a>
            </div>
        </div><!-- Fine Seconda Card-->

        <!-- Inizio Terza Card-->
        <div class="my-3 card bg-light mx-auto" style="width: 20rem;">
            <img src="img/booking.jpg">
            <div class="card-body">
                <h4 class="card-title">Prenotazioni</h4>
                <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate,
                    con informazioni come data orario e luogo.</p>
                <form action="ShowBookingServlet" method="post">
                    <input type="hidden" name="email" value="${email}">
                    <button class="btn btn-primary">Visualizza prenotazioni</button>
                </form>
            </div>
        </div><!-- Fine Seconda Card-->
    </div><!-- FINE SEZIONE CARD-->
</header>


<!-- Footer-->
<footer class="bg-light py-5">
    <div class="container px-4 px-lg-5"><div class="small text-center text-muted">Copyright &copy; 2023 - ApPost</div></div>
</footer>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

<script src="js/scripts.js"></script>

</body>
</html>