<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Profile</title>
  <!-- Link al foglio di stile di Bootstrap -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

  <style>
    .logo {
      width: 60px;
      height: 60px;
      border-radius: 50%;
      background-color: green;
      position: absolute;
      top: 15px;
      left: 15px;
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
      font-weight: bold;
      font-size: 15px;
      font-style:italic;
    }
    .logo span {
      display: block;
      text-align: center;
    }
    body {
      background: #31343f;
    }
    .brand {
      color: #40ad33;
    }
    .border-hover {
      border-top: 5px solid transparent;
      transform: translateY(-4px);
    }
    .border-hover:hover {
      border-top: 5px solid #40ad33;
      transform: translateY(-4px);
    }
    #sign-in {
      background: #40ad33;
      border-top-left-radius: 50px;
      border-bottom-left-radius: 50px;
    }
    .navbar-toggler {
      border: 1px solid #40ad33;
    }
    .navbar-toggler-icon {
      background-image: url(/static_files/svgs3/list.svg)
    }
    .navbar-toggler:focus {
      box-shadow: none;
    }
    #nav-length {
      width: 40%;
    }
    @media screen and (max-width : 992px) {
      #nav-length {
        width: 100%;
      }
      .border-hover {
        border-top: 0;
      }
      .border-hover:hover {
        border-top: 0;
      }
      #sign-in {
        border-radius: 50px;
      }
    }
    footer {
      background-color: #333;
      width: 100%;
      bottom: 0;
      position: fixed;
    }
    /* body section */
    .icon-height {
      height: 28px;
      width: 28px;
    }
    .icon-container {
      background: #FF9138;
    }
    .dark-background {
      background: #2b3944;
    }
  </style>
</head>
<body>

<nav>
  <div class="navbar navbar-expand-lg pt-4">
    <div class="container-fluid">
      <a href="#" class="brand text-decoration-none d-block d-lg-none fw-bold fs-1 ">LOGO</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul id="nav-length" class="navbar-nav justify-content-between border-top border-2 text-center">
          <li class="nav-item">
            <a href="descrizioneApp.jsp" class="nav-link border-hover py-3 text-white">Chi siamo</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link border-hover py-3 text-white">Contatti</a>
          </li>
          <li class="nav-item">
            <a href="index.jsp" id="sign-in" class="nav-link my-2 px-4 text-white">
              Esci
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>

<div class="row">

  <div class="my-5 card bg-light mx-auto" style="width: 18rem;">
    <img src="https://i2.res.24o.it/images2010/Editrice/ILSOLE24ORE/PLUS24/2022/10/01/Plus24/Immagini/Trattate/AdobeStock_279423926-kkY--1020x533@IlSole24Ore-Web.jpeg?r=540x283"
         alt="100">
    <div class="card-body">
      <h5 class="card-title">Dati personali</h5>
      <p class="card-text">Qui vengono visualizzati i tuoi dati personali, come nome, cognome, indirizzo e-mail, ecc.</p>
      <a href="#" class="btn btn-primary">Modifica</a>
    </div>
  </div>

  <div class="my-5 card bg-light mx-auto" style="width: 18rem;">
    <img src="https://www.comunicazione21.com/wp-content/uploads/2018/09/plugin-prenotazioni-copertina.jpg"
         alt="50">
    <div class="card-body">
      <h5 class="card-title">Prenotazioni</h5>
      <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate, con informazioni come la data, l'ora, il luogo, ecc.</p>
      <a href="#" class="btn btn-primary">Visualizza tutto</a>
    </div>
  </div>

  <div class="my-5 card mx-auto bg-light" style="width: 18rem;">
    <img src="https://motori.virgilio.it/wp-content/uploads/sites/4/2021/07/auto-parcheggiate.jpg"
         class="card-img-top"
         alt="100">
    <div class="card-body">
      <h5 class="card-title">I miei veicoli</h5>
      <p class="card-text">Qui vengono visualizzati i veicoli posseduti, con informazioni come la marca, il modello, l'anno di produzione, ecc.</p>
      <a href="#" class="btn btn-primary">Aggiungi nuovo veicolo</a>
    </div>
  </div>
</div>
<!-- Link agli script di Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<div class>
  <footer class="bg-dark text-center text-white">
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2023 Copyright:
      <a class="text-white" href="index.jsp">ApPost.com</a>
    </div>
    <!-- Copyright -->
  </footer>
</div>

</body>
</html>

</body>
</html>
