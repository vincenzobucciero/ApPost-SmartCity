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

  <style>
    .btn-group-vertical>.btn:not(:first-child),
    .btn-group-vertical>.btn-group:not(:first-child) {
      margin-top: 0;
    }
  </style>

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
            <a class="dropdown-item" href="logout">Esci</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Masthead-->
<header class="masthead">
  <div class="col-lg-10 mx-auto mb-4">
    <h2 class="text-center mt-0" style="color: white">Scegli come pagare</h2>
    <hr class="divider" style="max-width: 10rem" />
  </div>
  <div class="row">
    <div class="col-lg-6 mx-auto">
      <div class="card">
        <div class="card-header">
          <div class="bg-white shadow-sm pt-4 pl-2 pr-2 pb-2">
            <!-- Credit card form tabs -->
            <ul role="tablist" class="nav bg-light nav-pills rounded nav-fill mb-3">
              <li class="nav-item">
                <a data-toggle="pill" href="#credit-card" class="nav-link active"> <i class="fas fa-credit-card mr-2"></i> Carta di Credito </a>
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
                    <input type="text" name="numCarta" placeholder="5136 1845 5468 3894" oninput="inputHandler(this)" class="form-control" required maxlength="19" />
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
                      <label data-toggle="tooltip" title="Trovi il codice CVV a tre cifre sul retro della carta">
                        <h6>CVV <i class="fa fa-question-circle d-inline"></i></h6>
                      </label>
                      <input type="password" name="cvv" required class="form-control" maxlength="3" />
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

    <div class="col-lg-4 mx-lg-4" style="padding: 2.5rem">
      <div class="p-3" style="background-color: #ffffff;">
        <span class="fw-bold" style="color: #F4623AFF">Riepilogo dell'ordine</span>
        <hr />
        <div class="d-flex justify-content-between mt-2">
          <c:choose>
          <c:when test="${bookingBean != null}">
          <span class="bold">Parcheggio</span>
          <span class="fst-italic">${bookingBean.getNomeParcheggio()}</span>
        </div>
        <hr />
        <div class="d-flex justify-content-between mt-2">
          <span class="bold">Data</span> <span class="fst-italic">${bookingBean.getData_prenotazione()}</span>
        </div>
        <div class="d-flex justify-content-between mt-2">
          <span class="bold">Ore prenotazione</span> <span class="fst-italic"> ${bookingBean.getOrario_inizio()} - ${bookingBean.getOrario_fine()}</span>
        </div>
        <hr />

        <div class="d-flex justify-content-between mt-2">
          <span class="bold">Commissioni</span> <span class="text-muted">1.50€</span>
        </div>
        <div class="d-flex justify-content-between mt-2">
          <span class="bold">Prezzo prenotazione</span> <span>${bookingBean.getPrezzo()}0€</span>
        </div>
        <hr />
        <div class="d-flex justify-content-between mt-2">
          <span class="bold">Totale </span> <span class="text-primary bold">${bookingBean.getPrezzo() + 1.50}0€</span>
        </div>
        </c:when>
        </c:choose>
      </div>
    </div>

  </div>
</header>

<!-- Footer-->
<footer class="bg-light py-5">
  <div class="container px-4 px-lg-5">
    <div class="small text-center text-muted">
      Copyright &copy; 2023 - ApPost
    </div>
  </div>
</footer>


<script>
  function inputHandler(input) {
    // Rimuove tutti i caratteri non numerici dalla stringa
    input.value = input.value.replace(/\D/g, '');
    // Limita la lunghezza della stringa a 16 cifre
    input.value = input.value.slice(0, 16);
    // Aggiunge uno spazio ogni 4 cifre
    input.value = input.value.replace(/(\d{4})/g, '$1 ');
  }
</script>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>


</body>
</html>