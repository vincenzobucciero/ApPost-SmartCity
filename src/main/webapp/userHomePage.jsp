<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 22/03/23
  Time: 16:27
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

  <link rel="stylesheet" type="text/css" href="CSS/styleMap.css" />
  <script type="module" src="js/jsMap.js"></script>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="index.jsp">ApPost</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto my-2 my-lg-0">
        <li class="nav-item dropdown" style="font-family: 'Inter'">
          <a class="nav-link dropdown-toggle" href="#funzionalita" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Funzionalità
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="SearchServlet">Prenota</a>
            <input type="hidden" name="email" value="${email}">
            <a class="dropdown-item" href="ShowBookingServlet">Le mie prenotazioni</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="homepage">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
              <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146ZM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5Z"/>
            </svg>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="PersonalServlet">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
            </svg>
          </a>
        </li>
        <li class="nav-item dropdown" style="font-family: 'Inter'">
          <a class="nav-link dropdown-toggle" href="#funzionalita" id="navbarDropdownExit" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
              <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
            </svg>
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownExit">
            <a class="dropdown-item" href="aiuto">Aiuto</a>
            <a class="dropdown-item" href="logout" onclick="return confermaLogout()">Esci</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>


<!-- Inizio MasterHead-->
<header class="masthead">
  <div class="container">
    <div class="col-lg-10 mx-auto mb-4">
      <h2 class="text-center mt-0" style="color: white">Bentornato,
        <c:choose>
          <c:when test="${userBean != null}">
            ${userBean.getNome()}
          </c:when>
        </c:choose>
      </h2>
      <hr class="divider" style="max-width: 13rem;" />
    </div>
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

</header> <!-- Fine MasterHead-->

<section class="page-section" style="padding: 2rem" id="funzionalita">

  <div class="col-lg-10 mx-auto mb-4">
    <h2 class="text-center mt-0" style="color: black">Funzionalità</h2>
    <hr class="divider" />
  </div>
  <!--INIZIO SEZIONE CARD-->
  <div class="row">
    <!-- Inizio Prima Card-->
    <div class="my-5 card bg-light" style="width: 20rem;" id="personal">
      <img src="img/imgCard/personalData.jpg">
      <div class="card-body">
        <h4 class="card-title">Dati personali</h4>
        <p class="card-text">Qui vengono visualizzati i dati personali di </p>
        <p>
          <c:choose>
          <c:when test="${userBean != null}">
        <p class="text-muted mb-0">
            ${userBean.getNome()}
            ${userBean.getCognome()}
        </p>
        </c:when>
        </c:choose>
        </p>
        <a href="PersonalServlet" class="btn btn-primary text-center">Visualizza i tuoi dati</a>
      </div>
    </div><!-- Fine Prima Card-->

    <!-- Inizio Seconda Card-->
    <div class="my-5 card bg-light mx-auto" style="width: 20rem;" id="prenota">
      <img src="img/park6.jpg">
      <div class="card-body">
        <h4 class="card-title">Prenota</h4>
        <p class="card-text">Qui puoi effettuare una nuova prenotazione in uno dei nostri parcheggi.</p><br>
        <a href="SearchServlet" class="btn btn-primary text-center">Effettua una prenotazione</a>
      </div>
    </div><!-- Fine Seconda Card-->

    <!-- Inizio Terza Card-->
    <div class="my-5 card bg-light" style="width: 20rem;" id="booking">
      <img src="img/imgCard/prenotazione.jpg">
      <div class="card-body">
        <h4 class="card-title">Le mie prenotazioni</h4>
        <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate,
          con informazioni come data orario e luogo.</p>
        <form action="ShowBookingServlet" method="post">
          <input type="hidden" name="email" value="${email}">
          <button class="btn btn-primary">Visualizza prenotazioni</button>
        </form>
      </div>
    </div><!-- Fine Terza Card-->

  </div><!-- FINE SEZIONE CARD-->


</section>

<!-- Footer-->
<footer class="bg-light py-5">
  <div class="container px-4 px-lg-5">
    <div class="small text-center text-muted">
      Copyright &copy; 2023 - ApPost
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

<!--L'attributo defer fa sì che la funzione di callback venga eseguita
       dopo che l'intero documento HTML è stato analizzato. Per utilizzi non
       bloccanti, evitando condizioni di gara e comportamenti coerenti tra
       browser, considera il caricamento tramite Promises con
       https://www.npmjs.com/package/@googlemaps/js-api-loader.-->

<!--Qui importiamo lo script di google maps dove però
    andiamo a modificare la chiave API che abbiamo generato -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA23kxKNlGB1Gw7UQdz4zbemqIZSG93JUQ&callback=initMap">
</script>

<script>
  function confermaLogout() {
    return confirm("Sei sicuro di voler uscire?");
  }
</script>

</body>
</html>