<%--
  Created by IntelliJ IDEA.
  User: carmine
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
  <!-- SimpleLightbox plugin CSS-->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <meta charset="UTF-8">
  <!-- This script got from frontendfreecode.com -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>

  <link rel="stylesheet" href="css/stylePay.css">
  <link rel="stylesheet" href="css/style.css">
  <script type="module" src="js/jsPay.js"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Pagamento</title>

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
  <div class="row">
    <div class="col-lg-6 mx-auto">
      <div class="card">
        <div class="card-header">
          <div class="bg-white shadow-sm pt-4 pl-2 pr-2 pb-2">
            <!-- Credit card form tabs -->
            <ul role="tablist" class="nav bg-light nav-pills rounded nav-fill mb-3">
              <li class="nav-item">
                <a data-toggle="pill" href="#credit-card" class="nav-link active"> <i class="fas fa-credit-card mr-2"></i> Credit Card </a>
              </li>
              <li class="nav-item">
                <a data-toggle="pill" href="#paypal" class="nav-link"> <i class="fab fa-paypal mr-2"></i> Paypal </a>
              </li>
            </ul>
          </div>
          <!-- End -->
          <!-- Credit card form content -->
          <div class="tab-content">
            <!-- credit card info-->
            <div id="credit-card" class="tab-pane fade show active pt-3">
              <form action="PayServlet" method="post">
                <div class="form-group">
                  <label name="username"> <!--Intestatario-->
                    <h6>Intestatario Carta</h6>
                  </label>
                  <input type="text" name="intestatario" placeholder="Mario Rossi" style="text-transform: uppercase" required class="form-control" />
                </div>
                <div class="form-group">
                  <label name="cardNumber"><!--Numero Carta-->
                    <h6>Numero Carta</h6>
                  </label>
                  <div class="input-group">
                    <input type="number" name="numCarta" placeholder="5136 1845 5468 3894" maxlength="16" class="form-control" required />
                    <div class="input-group-append">
                                            <span class="input-group-text text-muted">
                                                <i class="fab fa-cc-visa mx-1"></i>
                                                <i class="fab fa-cc-mastercard mx-1"></i>
                                                <i class="fab fa-cc-amex mx-1"></i>
                                            </span>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-8">
                    <div class="form-group">
                      <label>
                                                <span class="hidden-xs"><!--Data di Scadenza-->
                                                    <h6>Data Scadenza</h6>
                                                </span>
                      </label>
                      <div class="input-group">
                        <input type="number" placeholder="MM" name="MM" class="form-control" value="1" min="1" max="12" required />
                        <input type="number" placeholder="YY" name="YYYY" class="form-control" value="23" min="23" max="30" required />
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="form-group mb-4"> <!--CVV-->
                      <label data-toggle="tooltip" title="Three digit CV code on the back of your card">
                        <h6>CVV <i class="fa fa-question-circle d-inline"></i></h6>
                      </label>
                      <input type="password" name="cvv" required class="form-control" />
                    </div>
                  </div>
                </div>
                <div class="card-footer"> <!--Conferma Pagamento-->
                  <input type="hidden" name="bookingBean" value="${bookingBean}">
                  <input type="hidden" name="email" value="${email}">
                  <input type="hidden" name="nomeP" value="${nomeP}">
                  <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm">
                    Conferma Pagamento
                  </button>
                </div>
              </form>
            </div>
            <!-- End -->


            <!-- Paypal info -->
            <div id="paypal" class="tab-pane fade pt-3">
              <form action="PayPalServlet" method="post">
                <div class="form-group">
                  <label name="emailPP">
                    <h6>Email</h6>
                  </label>
                  <input type="text" name="emailPP" placeholder="mariorossi@gmail.com" required class="form-control"  />
                </div>
                <div class="form-group">
                  <label name="passwordPP">
                    <h6>Password</h6>
                  </label>
                  <input type="password" name="passwordPP" required class="form-control" />
                </div>
                <p>
                  <input type="hidden" name="bookingBean" value="${bookingBean}">
                  <button type="submit" class="btn btn-primary">
                    <i class="fab fa-paypal mr-2"></i>
                    Accedi in Paypal
                  </button>
                </p>
                <p class="text-muted">
                  Nota: dopo aver fatto clic sul pulsante, completerai l'acquisto sul tuo account PayPal. Dopo aver completato il processo di pagamento,
                  verrai reindirizzato al nostro sito Web per visualizzare i dettagli del tuo ordine.
                </p>
              </form>
            </div>
            <!-- End -->
          </div>
        </div>
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