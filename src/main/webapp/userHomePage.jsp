<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

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

  <!-- API Google Maps-->
  <title>ApPost - My Home</title>
  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" type="text/css" href="css/styleMap.css" />
  <script type="module" src="js/jsMap.js"></script>
  <script type="module" src="TySc/tyS.ts"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="index.jsp">ApPost</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto my-2 my-lg-0">
        <li class="nav-item"><a class="nav-link" href="userHomePage.jsp">Torna alla Home</a></li>
        <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Inizio MasterHead-->
<header class="masthead">
  <div class="container">
    <div class="my-5 card bg-dark mx-auto" style="width:60rem;">
      <div class="card">
        <div class="card-body">
          <p class="text-muted mb-0">Scegli il parcheggio:</p>
          <!--The div element for the map -->
          <div id="map"></div> <!-- Qua esce la mappa-->
        </div>
      </div>
    </div>
  </div>
  <!--L'attributo defer fa sì che la funzione di callback venga eseguita
      dopo che l'intero documento HTML è stato analizzato. Per utilizzi non
      bloccanti, evitando condizioni di gara e comportamenti coerenti tra
      browser, considera il caricamento tramite Promises con
      https://www.npmjs.com/package/@googlemaps/js-api-loader.-->

  <!--Qui importiamo lo script di google maps dove però
      andiamo a modificare la chiave API che abbiamo generato -->
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA23kxKNlGB1Gw7UQdz4zbemqIZSG93JUQ&callback=initMap">
  </script>

  <!--INIZIO SEZIONE CARD-->
  <div class="row">
    <!-- Inizio Prima Card-->
    <div class="my-5 card bg-light" style="width: 20rem;">
      <img src="img/imgCard/personalData.jpg">
      <div class="card-body">
        <h4 class="card-title">Dati personali</h4>
        <p class="card-text">Qui vengono visualizzati i dati personali di </p>
        <p><c:choose>
          <c:when test="${usersBean != null}">
        <p class="text-muted mb-0">
            ${usersBean.getNome()}
            ${usersBean.getCognome()}
        </p>
        </c:when>
        </c:choose>
        </p>
        <a href="PersonalServlet" class="btn btn-primary">Visualizza</a>
      </div>
    </div><!-- Fine Prima Card-->

    <!-- Inizio Seconda Card-->
    <div class="my-5 card bg-light mx-auto" style="width: 20rem;">
      <img src="img/imgCard/prenotazione.jpg">
      <div class="card-body">
        <h4 class="card-title">Prenotazioni</h4>
        <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate,
          con informazioni come la data, l'ora, il luogo.</p>
        <a href="SearchServlet" class="btn btn-primary">Effettua una prenotazione</a>
      </div>
    </div><!-- Fine Seconda Card-->

    <!-- Inizio Terza Card-->
    <div class="my-5 card bg-light" style="width: 20rem;">
      <img src="img/park6.jpg">
      <div class="card-body">
        <h4 class="card-title">I miei veicoli</h4>
        <p class="card-text">Qui vengono visualizzati i veicoli posseduti.</p>
        <a href="#" class="btn btn-primary">Aggiungi nuovo veicolo</a>
      </div>
    </div><!-- Fine Terza Card-->

  </div><!-- FINE SEZIONE CARD-->

</header> <!-- Fine MasterHead-->


<!-- Footer-->
<footer class="bg-light py-5">
  <div class="container px-4 px-lg-5">
    <div class="small text-center text-muted">
      Copyright &copy; 2023 - Company Name
    </div>
  </div>
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