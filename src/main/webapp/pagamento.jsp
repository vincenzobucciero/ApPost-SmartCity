<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 4/6/23
  Time: 4:49 PM
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
  <link rel="stylesheet" href="css/styleBooking.css">
  <link rel="stylesheet" href="css/stylePay.css">
  <script type="module" src="js/jsPay.js"></script>
  <script type="module" src="js/jsCambioPay.js"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Pagamento</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-2" id="mainNav">
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
  <div class="container px-4 px-lg-5 h-100">
    <div class="container bg-light d-md-flex align-items-center">
      <!--Riquadro SX-->
      <div class="card box1 shadow-sm p-md-5 p-md-5 p-4">

        <div class="d-flex flex-column">
          <div class="d-flex align-items-center justify-content-between text">
            <span class="">Commissione</span>
            <span class="fas fa-dollar-sign">
                        <span class="ps-1">1.99</span>
                    </span>
          </div>
          <div class="d-flex align-items-center justify-content-between text mb-4">
            <span>Totale</span>
            <span class="fas fa-dollar-sign">
                        <span class="ps-1">7.99</span>
                    </span>
          </div>
          <div class="border-bottom mb-4"></div>
          <div class="d-flex flex-column mb-4">
                    <span class="far fa-file-alt text">
                        <span class="ps-2">ID prenotazione:</span>
                    </span>
            <span class="ps-3">SN8478042099</span>
          </div> <div class="d-flex flex-column mb-5">
                <span class="far fa-calendar-alt text">
                    <span class="ps-2">Data pagamento:</span>
                </span>
          <span class="ps-3">22/06/2023</span>
        </div>
          <div class="d-flex align-items-center justify-content-between text mt-5">
            <div class="d-flex flex-column text">
              <span>Supporto:</span>
              <span>online chat 24/7</span>
            </div>
            <div class="btn btn-primary rounded-circle">
              <i class="bi bi-chat-dots-fill"></i>
            </div>
          </div>
        </div>
      </div>

      <!--Riquadro DX-->
      <div class="card box2 shadow-sm"> <!--MiniNav-->
        <div class="d-flex align-items-center justify-content-between p-md-5 p-4">
          <span class="h5 fw-bold m-0">Metodo di Pagamento</span>
          <div class="btn btn-primary bar">
            <span class="fas fa-bars"></span>
          </div>
        </div>
        <ul class="nav nav-tabs mb-3 px-md-3 px-2">
          <li class="nav-item">
            <a class="nav-link active" href="#creditsCard">Carta di Credito</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#debitCard">Carta di Debito</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#contanti">Contanti</a>
          </li>
          <li class="nav-indicator"></li>
        </ul>
        <form action="PayServlet" method="post">
          <div class="row">
            <div class="col-12">
              <div class="col-12">
                <div class="d-flex flex-column px-md-5 px-4 mb-4">
                  <span>Nome</span>
                  <div class="inputWithIcon">
                    <input class="form-control text-uppercase" type="text" placeholder="Mario Rossi">
                    <span class="far fa-user"></span>
                  </div>
                </div>
              </div>
              <div class="d-flex flex-column px-md-5 px-4 mb-4">
                <span>Numero Carta</span>
                <div class="inputWithIcon">
                  <input class="form-control" type="text" placeholder="5136 1845 5468 3894">
                  <i class="bi bi-credit-card"></i>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="d-flex flex-column ps-md-5 px-md-0 px-4 mb-4">
                <span>Scadenza</span>
                <div class="inputWithIcon">
                  <input type="text" class="form-control" placeholder="05/20">
                  <span class="fas fa-calendar-alt">
                                </span>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="d-flex flex-column pe-md-5 px-md-0 px-4 mb-4">
                <span>CVV</span>
                <div class="inputWithIcon">
                  <input type="password" class="form-control" placeholder="123">
                  <span class="fas fa-lock"></span>
                </div>
              </div>
            </div>
            <div class="col-12 px-md-5 px-4 mt-3">
              <input type="hidden" name="bookingBean" value="${bookingBean}">
              <button type="submit" class="btn btn-primary w-100">Paga $7.99</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</header>

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