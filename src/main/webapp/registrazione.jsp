<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>ApPost-Mio Profilo</title>
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
  <link rel="stylesheet" href="CSS/styleProva.css">
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
        <li class="nav-item"><a class="nav-link" href="profilo.jsp">Torna alla home</a></li>
        <li class="nav-item"><a class="nav-link" href="about.jsp">Chi siamo</a></li>
        <li class="nav-item"><a class="nav-link" href="#services">Servizi</a></li>
        <li class="nav-item"><a class="nav-link" href="index.jsp">Esci</a></li>
      </ul>
    </div>
  </div>
</nav>

<!--Masthead-->
<header class="masthead">
  <div class="row">
    <div class="my-5 card bg-light mx-auto" style="width: 20rem;">
      <img src="https://i2.res.24o.it/images2010/Editrice/ILSOLE24ORE/PLUS24/2022/10/01/Plus24/Immagini/Trattate/AdobeStock_279423926-kkY--1020x533@IlSole24Ore-Web.jpeg?r=540x283"
           alt="100">
      <div class="card-body">
        <h5 class="card-title">Dati personali</h5>
        <p class="card-text">Qui vengono visualizzati i dati personali di </p>
        <c:choose>
          <c:when test="${usersBean != null}">
            <h4 class="dark-background">
                ${usersBean.getNome()}
                ${usersBean.getCognome()}</h4>
          </c:when>
        </c:choose>
        <a href="personal.jsp" class="btn btn-primary">Visualizza</a>
      </div>
    </div>

    <div class="my-5 card bg-light mx-auto" style="width: 20rem;">
      <img src="https://www.comunicazione21.com/wp-content/uploads/2018/09/plugin-prenotazioni-copertina.jpg"
           alt="50">
      <div class="card-body">
        <h5 class="card-title">Prenotazioni</h5>
        <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate,
          con informazioni come la data, l'ora, il luogo, ecc.</p>
        <a href="#" class="btn btn-primary">Visualizza tutto</a>
      </div>
    </div>

    <div class="my-5 card mx-auto bg-light" style="width: 20rem;">
      <img src="https://motori.virgilio.it/wp-content/uploads/sites/4/2021/07/auto-parcheggiate.jpg"
           class="card-img-top"
           alt="100">
      <div class="card-body">
        <h5 class="card-title">I miei veicoli</h5>
        <p class="card-text">Qui vengono visualizzati i veicoli posseduti,
          con informazioni come la marca, il modello, l'anno di produzione, ecc.</p>
        <a href="#" class="btn btn-primary">Aggiungi nuovo veicolo</a>
      </div>
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
