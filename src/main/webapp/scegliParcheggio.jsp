<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 5/1/23
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>ApPost-Registrazione</title>
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
  <link rel="stylesheet" href="css/styleFormLogin.css">
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
        <li class="nav-item"><a class="nav-link" href="#services">Servizi</a></li>
        <li class="nav-item"><a class="nav-link" href="#about">Chi siamo</a></li>
        <li class="nav-item"><a class="nav-link" href="login.jsp">Accedi</a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- Masthead-->
<header class="masthead">
  <div class="container px-4 px-lg-5 h-100">
    <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center"></div>
  </div>
</header>

<!-- Form-->
<div class="form-bg">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="form-container">
          <div class="form-icon"><i class="bi bi-person-circle"></i></div>
          <h3 class="title">Crea un account</h3>
          <form class="form-horizontal" action="${pageContext.request.contextPath}/registration" method="post">
            <div class="form-group row">
              <div class="col-md-4">
                <label>nome</label>
                <input name="name" class="form-control" id="name" type="text" placeholder="es. Mario" required>
              </div>
              <div class="col-md-4">
                <label>cognome</label>
                <input name="surname" class="form-control" id="surname" type="text" placeholder="es. Rossi" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-md-4">
                <label>email</label>
                <input name="email" class="form-control" id="email" type="email" placeholder="es. mariorossi@gmail.com" required>
              </div>
              <div class="col-md-4">
                <label>password</label>
                <input name="password" class="form-control" id="password" type="password" placeholder="es. password123" required>
              </div>
            </div>
            <button type="submit" class="btn btn-primary btn-lg text-white">Registrati</button>
            <div class="text-center">
              <a href="login.jsp" class="text-secondary">Accedi ora</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<!--Parte chi siamo e servizi -->
<!-- Services-->
<section class="page-section" id="services">
  <div class="container px-4 px-lg-5">
    <h2 class="text-center mt-0">I nostri servizi</h2>
    <hr class="divider" />
    <div class="row gx-4 gx-lg-5">
      <div class="col-lg-3 col-md-6 text-center">
        <div class="mt-5">
          <!--<div class="mb-2"><i class="bi-gem fs-1 text-primary"></i></div>-->
          <div><svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" style="color: #F4623AE5" class="bi bi-ticket-detailed" viewBox="0 0 16 16">
            <path d="M4 5.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5Zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5ZM5 7a1 1 0 0 0 0 2h6a1 1 0 1 0 0-2H5Z"/>
            <path d="M0 4.5A1.5 1.5 0 0 1 1.5 3h13A1.5 1.5 0 0 1 16 4.5V6a.5.5 0 0 1-.5.5 1.5 1.5 0 0 0 0 3 .5.5 0 0 1 .5.5v1.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 11.5V10a.5.5 0 0 1 .5-.5 1.5 1.5 0 1 0 0-3A.5.5 0 0 1 0 6V4.5ZM1.5 4a.5.5 0 0 0-.5.5v1.05a2.5 2.5 0 0 1 0 4.9v1.05a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-1.05a2.5 2.5 0 0 1 0-4.9V4.5a.5.5 0 0 0-.5-.5h-13Z"/>
          </svg></div>
          <h3 class="h4 mb-2">Prenotazioni</h3>
          <p class="text-muted mb-0">Prenota il tuo posto auto in anticipo
            per evitare l'ansia del parcheggio dell'ultimo minuto.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="mt-5">
          <!--<div class="mb-2"><i class="bi-laptop fs-1 text-primary"></i></div>-->
          <div><svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" style="color: #F4623AE5" class="bi bi-coin" viewBox="0 0 16 16">
            <path d="M5.5 9.511c.076.954.83 1.697 2.182 1.785V12h.6v-.709c1.4-.098 2.218-.846 2.218-1.932 0-.987-.626-1.496-1.745-1.76l-.473-.112V5.57c.6.068.982.396 1.074.85h1.052c-.076-.919-.864-1.638-2.126-1.716V4h-.6v.719c-1.195.117-2.01.836-2.01 1.853 0 .9.606 1.472 1.613 1.707l.397.098v2.034c-.615-.093-1.022-.43-1.114-.9H5.5zm2.177-2.166c-.59-.137-.91-.416-.91-.836 0-.47.345-.822.915-.925v1.76h-.005zm.692 1.193c.717.166 1.048.435 1.048.91 0 .542-.412.914-1.135.982V8.518l.087.02z"/>
            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
            <path d="M8 13.5a5.5 5.5 0 1 1 0-11 5.5 5.5 0 0 1 0 11zm0 .5A6 6 0 1 0 8 2a6 6 0 0 0 0 12z"/>
          </svg></div>
          <h3 class="h4 mb-2">Pagamenti</h3>
          <p class="text-muted mb-0">Paga il parcheggio direttamente
            dall'app, senza dover cercare il cambio o la carta di credito.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="mt-5">
          <!--<div class="mb-2"><i class="bi-globe fs-1 text-primary"></i></div>-->
          <div><svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" style="color: #F4623AE5" class="bi bi-piggy-bank" viewBox="0 0 16 16">
            <path d="M5 6.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0zm1.138-1.496A6.613 6.613 0 0 1 7.964 4.5c.666 0 1.303.097 1.893.273a.5.5 0 0 0 .286-.958A7.602 7.602 0 0 0 7.964 3.5c-.734 0-1.441.103-2.102.292a.5.5 0 1 0 .276.962z"/>
            <path fill-rule="evenodd" d="M7.964 1.527c-2.977 0-5.571 1.704-6.32 4.125h-.55A1 1 0 0 0 .11 6.824l.254 1.46a1.5 1.5 0 0 0 1.478 1.243h.263c.3.513.688.978 1.145 1.382l-.729 2.477a.5.5 0 0 0 .48.641h2a.5.5 0 0 0 .471-.332l.482-1.351c.635.173 1.31.267 2.011.267.707 0 1.388-.095 2.028-.272l.543 1.372a.5.5 0 0 0 .465.316h2a.5.5 0 0 0 .478-.645l-.761-2.506C13.81 9.895 14.5 8.559 14.5 7.069c0-.145-.007-.29-.02-.431.261-.11.508-.266.705-.444.315.306.815.306.815-.417 0 .223-.5.223-.461-.026a.95.95 0 0 0 .09-.255.7.7 0 0 0-.202-.645.58.58 0 0 0-.707-.098.735.735 0 0 0-.375.562c-.024.243.082.48.32.654a2.112 2.112 0 0 1-.259.153c-.534-2.664-3.284-4.595-6.442-4.595zM2.516 6.26c.455-2.066 2.667-3.733 5.448-3.733 3.146 0 5.536 2.114 5.536 4.542 0 1.254-.624 2.41-1.67 3.248a.5.5 0 0 0-.165.535l.66 2.175h-.985l-.59-1.487a.5.5 0 0 0-.629-.288c-.661.23-1.39.359-2.157.359a6.558 6.558 0 0 1-2.157-.359.5.5 0 0 0-.635.304l-.525 1.471h-.979l.633-2.15a.5.5 0 0 0-.17-.534 4.649 4.649 0 0 1-1.284-1.541.5.5 0 0 0-.446-.275h-.56a.5.5 0 0 1-.492-.414l-.254-1.46h.933a.5.5 0 0 0 .488-.393zm12.621-.857a.565.565 0 0 1-.098.21.704.704 0 0 1-.044-.025c-.146-.09-.157-.175-.152-.223a.236.236 0 0 1 .117-.173c.049-.027.08-.021.113.012a.202.202 0 0 1 .064.199z"/>
          </svg></div>
          <h3 class="h4 mb-2">Risparmia</h3>
          <p class="text-muted mb-0">Risparmia tempo, fatica e
            denaro grazie alla nostra app di parcheggio smart.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="mt-5">
          <!--<div class="mb-2"><i class="bi-heart fs-1 text-primary"></i></div>-->
          <div><svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" style="color: #F4623AE5" class="bi bi-p-circle" viewBox="0 0 16 16">
            <path d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM5.5 4.002h2.962C10.045 4.002 11 5.104 11 6.586c0 1.494-.967 2.578-2.55 2.578H6.784V12H5.5V4.002Zm2.77 4.072c.893 0 1.419-.545 1.419-1.488s-.526-1.482-1.42-1.482H6.778v2.97H8.27Z"/>
          </svg></div>
          <h3 class="h4 mb-2">Parcheggio</h3>
          <p class="text-muted mb-0">Trova il parcheggio più vicino a te
            con un solo click, senza dover girare a vuoto in cerca di un posto auto disponibile.</p>
        </div>
      </div>
    </div>
  </div>
</section>
<!--About-->
<section class="page-section" id="about">
  <div class="container px-4 px-lg-5">
    <h2 class="text-center mt-0">Chi siamo</h2>
    <hr class="divider" />
    <div class="row gx-4 gx-lg-5">
      <!--<div class="col-lg-3 col-md-6 text-center">-->
      <div class="mt-5">
        <p class="text-muted mb-0">Quest'app di parcheggi smart è la soluzione perfetta
          per tutti coloro che cercano un modo semplice ed efficace per trovare il parcheggio
          perfetto. Con la tua app, puoi prenotare il parcheggio in anticipo e risparmiare
          tempo ed energia nella ricerca di un posto auto.
          Quest'app di parcheggi smart ti consente di cercare parcheggi nelle vicinanze della
          tua destinazione e di visualizzare il prezzo e la disponibilità in tempo reale.
          Puoi scegliere il parcheggio più conveniente e prenotarlo direttamente dall'app,
          senza dover cercare parcheggi a caso.
          Una volta parcheggiato, la nostra app ti consente di monitorare il tempo di parcheggio
          e di ricevere avvisi quando il tuo tempo sta per scadere. In questo modo, puoi
          evitare multe e ulteriori spese, e rimanere tranquillo durante la tua permanenza.
          Inoltre, la nostra app di parcheggi smart ti permette di guadagnare punti ogni volta
          che utilizzi la piattaforma. Questi punti possono essere convertiti in sconti sui
          tuoi prossimi parcheggi o altri premi, rendendo l'esperienza di parcheggio ancora
          più conveniente e gratificante.
          In definitiva, la nostra app di parcheggi smart è la soluzione ideale per tutti coloro
          che cercano un modo semplice e veloce per parcheggiare. Con la sua capacità di
          trovare parcheggi vicini, di prenotare in anticipo e di monitorare il tempo di
          parcheggio, questa app è un must-have per ogni automobilista moderno.</p>
      </div>
    </div>
  </div>
  <!--</div>-->
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

</body>
</html>

