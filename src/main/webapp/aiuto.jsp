<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 10/05/23
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <link rel="stylesheet" href="CSS/styleHelp.css">
  <link rel="stylesheet" href="CSS/style.css">

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Aiuto</title>
</head>
<body>

<!-- Navigation-->
<jsp:include page="NavBarUser.jsp" />

<!-- Masthead-->

<header class="masthead">
  <h1 style="color: white">Domande frequenti</h1>
  <hr class="divider" style="max-width: 10rem" />

  <div class="faqs-container">
    <div class="faq active">
      <h3 class="faq-title">
        Come faccio a prenotare un parcheggio?
      </h3>
      <p class="faq-text">
        Per prenotare un parcheggio sul nostro sito web,
        devi inserire la tua posizione di partenza e la tua destinazione nella pagina principale, dopodiché
        verranno quindi visualizzati i parcheggi disponibili per il tuo percorso, e potrai selezionare
        quello che preferisci e completare la prenotazione seguendo le istruzioni sullo schermo.
      </p>
      <button class="faq-toggle">
        <i class="bi bi-arrow-down-circle-fill"></i>
        <i class="fas fa-times"></i>
      </button>
    </div>

    <div class="faq">
      <h3 class="faq-title">
        Quali informazioni sono necessarie per effettuare una prenotazione?
      </h3>
      <p class="faq-text">
        Per effettuare una prenotazione, avrai bisogno di fornire alcune informazioni di base, come il tipo di veicolo e la targa.
        Viene richiesta anche la data e gli orari d'ingresso e uscita in cui vuoi parcheggiare.
      </p>
      <button class="faq-toggle">
        <i class="bi bi-arrow-down-circle-fill"></i>
        <i class="fas fa-times"></i>
      </button>
    </div>

    <div class="faq">
      <h3 class="faq-title">
        Quali opzioni di pagamento accetti per le prenotazioni?
      </h3>
      <p class="faq-text">
        Attualmente accettiamo pagamenti tramite carta di credito o PayPal, in alternativa accettiamo anche il pagamento presso ogni parcheggio.
      </p>
      <button class="faq-toggle">
        <i class="bi bi-arrow-down-circle-fill"></i>
        <i class="fas fa-times"></i>
      </button>
    </div>


    <div class="faq">
      <h3 class="faq-title">
        Quali informazioni personali devo fornire per registrarmi?
      </h3>
      <p class="faq-text">
        Per registrarti dovrai fornire alcune informazioni personali, come il tuo nome, l'indirizzo email e il numero di telefono. Potresti anche dover fornire informazioni sulla tua auto, a seconda dei requisiti del parcheggio.        </p>
      <button class="faq-toggle">
        <i class="bi bi-arrow-down-circle-fill"></i>
        <i class="fas fa-times"></i>
      </button>
    </div>


    <div class="faq">
      <h3 class="faq-title">
        Come posso modificare o cancellare una prenotazione esistente?
      </h3>
      <p class="faq-text">
        Per modificare o cancellare una prenotazione esistente, dovrai accedere al tuo account e seguire le istruzioni sullo schermo. In alternativa, puoi contattare il nostro servizio clienti per assistenza</p>
      <button class="faq-toggle">
        <i class="bi bi-arrow-down-circle-fill"></i>
        <i class="fas fa-times"></i>
      </button>
    </div>

  </div>




  <!-- SOCIAL PANEL HTML -->
  <div class="social-panel-container">
    <div class="social-panel">
      <button class="close-btn"><i class="fas fa-times"></i></button>
      <h4>Scrivici</h4>
      <ul>
        <li>
          <a  target="_blank">
            <i class="bi bi-facebook"></i>
          </a>
        </li>

        <li>
          <a target="_blank">
            <i class="bi bi-instagram"></i>
          </a>
        </li>

        <li>
          <a target="_blank">
            <i class="bi bi-twitter"></i>
          </a>
        </li>

        <li>
          <a target="_blank">
            <i class="bi bi-whatsapp"></i>
          </a>
        </li>
      </ul>
    </div>
  </div>
  <button class="floating-btn">
    Scrivici
  </button>

</header>

<header class="masthead"></header>

<jsp:include page="Footer.jsp" />

<script>
  const toggles = document.querySelectorAll('.faq-toggle');

  toggles.forEach(toggle => {
    toggle.addEventListener('click', () => {
      toggle.parentNode.classList.toggle('active');
    });
  });

  // SOCIAL PANEL JS
  const floating_btn = document.querySelector('.floating-btn');
  const close_btn = document.querySelector('.close-btn');
  const social_panel_container = document.querySelector('.social-panel-container');

  floating_btn.addEventListener('click', () => {
    social_panel_container.classList.toggle('visible')
  });

  close_btn.addEventListener('click', () => {
    social_panel_container.classList.remove('visible')
  });

</script>

</body>
</html>