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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- Google fonts-->
  <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
  <!-- SimpleLightbox plugin CSS-->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link rel="stylesheet" href="css/styleBooking.css">
  <link rel="stylesheet" href="css/style.css">

  <script type="module" src="js/scripts.js"></script>
  <script type="module" src="TySc/tyS.ts"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Prenotazione</title>
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
        <li class="nav-item"><a class="nav-link" href="userHomePage.jsp">Torna alla Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#aiuto">Come si prenota ?</a></li>
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
      <div class="form-container" style="font-family: 'Inter', sans-serif">

        <h3 class="title">
          Effettua la prenotazione
        </h3>
        <form id="bookingForm" class="form-horizontal" action="BookingServlet" method="post">
          <!--<div class = "form-group row">
                                    <div class="col-md-6">
                                        <label name="nomePark">Nome parcheggio</label>
                                        <input name="nomePark" class="form-control" type="text" placeholder="${parkingBean.getNomeParcheggio()}" readonly>
                                    </div>

                                    <div class="col-md-6">
                                        <label name="emailS">Email</label>
                                        <input name="emailS" class="form-control" type="text" style="font-family: 'Inter', sans-serif" placeholder="${email}" readonly>
                                    </div>
                                </div>-->
          <hr>
          <div class = "form-group row">

            <div class="col-md-4">
              <label name="dataP">Data</label>
              <input name="dataP"  class="form-control" type="date" required>
            </div>

            <div class="col-md-4">
              <label name="oraI">Orario ingresso</label>
              <input name="oraI" value="07:00" class="form-control" type="time" min="07:00" required>
            </div>

            <div class="col-md-4">
              <label name="oraF">Orario uscita</label>
              <input name="oraF" value="23:00" class="form-control" type="time" max="23:00" required>
            </div>
          </div>
          <hr>
          <div class = "form-group row">

            <div class="col-md-4">
              <label name="tipoV">Tipo Veicolo</label>
              <select class= "form-control" name="tipoV" required>
                <option value="">--scegli--</option>
                <option type="hidden" name="tipoV">Auto</option>
                <option type="hidden" name="tipoV">Furgone</option>
                <option type="hidden" name="tipoV">Moto</option>
              </select>
            </div>

            <div class="col-md-4">
              <label name="targa">Targa Veicolo</label>
              <input name="targa" class="form-control" type="text" style="text-transform: uppercase" style="font-family: 'Inter', sans-serif" placeholder="GH104RT" maxlength="7" required>
            </div>

            <div class="col-md-4">
              <label name="sceltaP">Metodo di pagamento</label>
              <select class= "form-control" name="sceltaP" required>
                <option value="">--scegli--</option>
                <option type="hidden" name="cartaC">Carta di Credito/PayPal</option>
                <option type="hidden" name="contanti">Al parcheggio</option>
              </select>
            </div>

          </div>
          <input type="hidden" name="email" value="${email}">
          <input type="hidden" name="nomeP" value="${nomeP}">
          <input type="hidden" name="bookingBean" value="${bookingBean}">

          <button type="submit" class="btn btn-primary btn-lg text-white alert">Pagamento
            <br><i class="bi bi-credit-card-2-back-fill"></i>
          </button>
        </form>
      </div><!--Fine form container-->

    </div>
  </div>
</div>


<!--Aiuto-->
<section class="page-section" id="aiuto">
  <div class="container px-4 px-lg-5">
    <h2 class="text-center mt-0">Come prenotare</h2>
    <hr class="divider" />
    <div class="row gx-4 gx-lg-5">
      <!--<div class="col-lg-3 col-md-6 text-center">-->
      <div class="mt-5">
        <p class="text-muted mb-0">Per prenotare un parcheggio attraverso la nostra app, è necessario
          seguire alcuni passaggi chiave. Prima di tutto, dovrai inserire la data in cui desideri
          parcheggiare il tuo veicolo. In seguito, dovrai selezionare l'orario d'ingresso nel
          parcheggio e l'orario di uscita (tutti i parcheggi sono disponibili dalle 07:00 alle 23:00). Dopo aver specificato gli orari d'ingresso e uscita,
          dovrai indicare il tipo di veicolo che intendi parcheggiare: auto, moto o furgone.
          Inserisci inoltre la targa del veicolo, in modo da poter identificare il tuo veicolo
          all'arrivo al parcheggio.
          Infine, dovrai scegliere il metodo di pagamento per la tua prenotazione. Puoi optare
          per il pagamento tramite carta di credito o Paypal, oppure scegliere di pagare in
          contanti direttamente al parcheggio.
          Una volta completati questi passaggi, la prenotazione sarà quasi completata. Se hai
          scelto il pagamento tramite carta di credito o Paypal, dovrai inserire i dati necessari
          per il pagamento e confermare la prenotazione. Se invece hai scelto di pagare in contanti
          al parcheggio, la prenotazione sarà comunque registrata e confermata, ma dovrai semplicemente
          pagare il costo del parcheggio all'arrivo.
          In ogni caso, riceverai una conferma della prenotazione attraverso l'app e sarai pronto per
          parcheggiare il tuo veicolo al tuo arrivo al parcheggio
        </p>
      </div>
    </div>
  </div>
</section>

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