<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 05/04/23
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

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
  <link rel="stylesheet" href="css/styleThanks.css">

  <script type="module" src="js/scripts.js"></script>
  <script type="module" src="TySc/tyS.ts"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Thanks</title>
</head>

<body>

<!--Navigation-->
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

<!--Masthead-->
<header class="masthead">
  <div class="border border-3 border-success"></div>
  <div class="card  bg-white shadow p-5">
    <div class="mb-4 text-center">
      <svg xmlns="http://www.w3.org/2000/svg" width="75" height="75" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
      </svg>
    </div>
    <div class="text-center">
      <h1>Prenotazione Effettuata</h1>
      <p>Grazie per averci scelto, puoi visualizzare le tue prenotazioni nella sezione dedicata,
        inoltre puoi effettuare una nuova prenotazione.</p>
      <button class="btn btn-outline-success" href="findPath.jsp">Nuova prenotazione</button>

      <div>
        <form action="ShowBookingServlet" method="post">
          <input type="hidden" name="email" value="${email}">
          <input type="hidden" name="bookingBean" value="${bookingBean}">

          <div class="text-center">
            <button class="btn btn-outline-success">Visualizza prenotazioni</button>
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