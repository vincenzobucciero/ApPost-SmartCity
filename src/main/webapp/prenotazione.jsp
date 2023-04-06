<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 4/4/23
  Time: 9:42 AM
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
  <link rel="stylesheet" href="css/styleFormLogin.css">
  <link rel="stylesheet" href="css/styleBooking.css">


  <script type="module" src="js/scripts.js"></script>
  <script type="module" src="TySc/tyS.ts"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Prenotazione</title>
</head>

<body body id="page-top">
<!-- Navigation-->
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
<!-- Masthead-->
<header class="masthead">
  <div class="container px-4 px-lg-5 h-100">
    <div class="row gx-4 gx-lg-5 h-50 align-items-center justify-content-center text-center"></div>
  </div>
</header>

<div class="form-bg">
  <div class="container">
    <div class="col-md-4 col-md-offset-4">
      <div class="form-container">
        <c:choose>
        <c:when test="${parkingBean != null}">
        <h3 class="title">
          Effettua la prenotazione
        </h3>
        <form id="bookingForm" class="form-horizontal" action="BookingServlet" method="post">
          <div class = "form-group row">
            <div class="col-md-5">
              <label name="nomePark">Nome parcheggio</label>
              <input name="nomePark" class="form-control" type="text" placeholder="${parkingBean.getNomeParcheggio()}" readonly>
            </div>

            <div class="col-md-5">
              <label name="emailS">Email</label>
              <input name="emailS" class="form-control" type="text" placeholder="${email}" readonly>
            </div>
          </div>
          <div class = "form-group row">
            <div class="col-md-5">
              <label name="targa">Targa Veicolo</label>
              <input name="targa" class="form-control" type="text" placeholder="es. DC104RT" required>
            </div>

            <div class="col-md-5">
              <label name="tipoV">Tipo Veicolo</label>
              <select class= "form-control" name="tipoV" required>
                <option value="">--scegli--</option>
                <option type="hidden" name="tipoV">Auto</option>
                <option type="hidden" name="tipoV">Furgone</option>
                <option type="hidden" name="tipoV">Moto</option>
              </select>
            </div>
          </div>

          <div class = "form-group row">
            <div class="col-md-4">
              <label name="dataP">Data</label>
              <input name="dataP" class="form-control" type="date" required>
            </div>

            <div class="col-md-4">
              <label name="oraI">Orario ingresso</label>
              <input name="oraI" class="form-control" type="time" required>
            </div>

            <div class="col-md-4">
              <label name="oraF">Orario uscita</label>
              <input name="oraF" class="form-control" type="time" required>
            </div>
          </div>
          <input type="hidden" name="email" value="${email}">
          <input type="hidden" name="id" value="${id}">

          <input type="hidden" name="bookingBean" value="${bookingBean}">
          <button type="submit" class="btn btn-primary btn-lg text-white">Pagamento
            <br><i class="bi bi-credit-card-2-back-fill"></i>
          </button>
        </form>
      </div><!--Fine form container-->
      </c:when>
      </c:choose>
    </div>
  </div>
</div>

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