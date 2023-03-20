<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
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
    footer {
      background-color: #333;
      width: 100%;
      bottom: 0;
      position: fixed;
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
  <div class="row justify-content-center align-items-center">
    <div class="col-sm-7 col-md-5 mb-3 mt-3">
      <div class="card rounded-0">
        <div class="card-header">
          <h3 class="text-center">Accedi alla tua area personale</h3>
        </div>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group ">
              <label for="email">Email</label>
              <input type="email" class="form-control border-0 rounded-0 bg-light" id="email" name="email" required>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control border-0 rounded-0 bg-light" id="password" name="password" required>
            </div>
            <div class="d-flex flex-column align-items-center">
              <button type="submit" class="btn btn-primary btn-lg mb-3">Accedi</button>
              <a href="registrazione.jsp" class="text-secondary">Registrati ora</a>
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