<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Page</title>
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
  </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="logo">
    <span>ApPost</span>
  </div>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="descrizioneApp.jsp">Chi siamo</a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="assistenza.jsp">Help</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">
  <div class="row">
    <div class="col-md-6 offset-md-3 mt-5">
      <div class="card">
        <div class="card-header">
          <h3 class="text-center">Registrati</h3>
          <p>Inserisci le tue informazioni necessarie per la creazione del tuo profilo</p>
        </div>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/registrazione.jsp" method="post">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Es. Mario" required>
            <div class="form-group">
              <label for="surname">Cognome</label>
              <input type="text" class="form-control" id="surname" name="surname" placeholder="Es. Rossi" required>
            </div>
            <div class="form-group">
              <label for="username">Username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Es. mario.rossi" required>
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Es. email@esempio.it" required>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control" id="password" name="password" placeholder="Es. password123" required>
            </div>
            <div class="form-group">
              <label for="vehicleType">Tipo veicolo</label>
              <select class="form-control" id="vehicleType" name="vehicleType" required>
                <option>Seleziona il tipo di veicolo</option>
                <option value="Auto">Auto</option>
                <option value="Moto">Moto</option>
                <option value="Furgone">Furgone</option>
              </select>
            </div>
            <div class="form-group">
              <label for="vehiclePlate">Targa del veicolo</label>
              <input type="text" class="form-control" id="vehiclePlate" name="vehiclePlate" placeholder="Es. AA000ZZ" required>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-lg">Register</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<footer class="bg-dark text-light py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <h3>Contatti</h3>
        <ul class="list-unstyled">
          <li><i class="fas fa-map-marker-alt"></i> Via Roma 123, 00100 Roma</li>
          <li><i class="fas fa-phone"></i> +39 06 12345678</li>
          <li><i class="fas fa-envelope"></i> info@esempio.it</li>
        </ul>
      </div>
      <div class="col-md-4">
        <h3>Links utili</h3>
        <ul class="list-unstyled">
          <li><a href="#">Termini e condizioni</a></li>
          <li><a href="#">Privacy policy</a></li>
          <li><a href="#">Cookie policy</a></li>
        </ul>
      </div>
      <div class="col-md-4">
        <h3>Social media</h3>
        <ul class="list-unstyled">
          <li><a href="#"><i class="fab fa-facebook-f"></i> Facebook</a></li>
          <li><a href="#"><i class="fab fa-twitter"></i> Twitter</a></li>
          <li><a href="#"><i class="fab fa-instagram"></i> Instagram</a></li>
        </ul>
      </div>
    </div>
    <hr>
    <p class="text-center">&copy; 2023 ApPost - Tutti i diritti riservati</p>
  </div>
</footer>



</body>
</html>

</body>
</html>
