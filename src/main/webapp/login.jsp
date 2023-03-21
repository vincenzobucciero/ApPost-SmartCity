<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/20/23
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>ApPost-Login</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
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
  <link rel="stylesheet" href="css/styleProva.css">
  <link rel="stylesheet" href="css/styleLogin.css">
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
        <li class="nav-item"><a class="navbar-light" href="about.jsp">Chi siamo</a></li>
        <li class="nav-item"><a class="navbar-light" href="#services">Servizi</a></li>
        <a href="registrazione.jsp" class="navbar-light">Registrati ora</a>
      </ul>
    </div>
  </div>
</nav>

<!-- Form-->
<div class="form-bg">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="form-container">
          <div class="form-icon"><i class="fa fa-user"></i></div>
          <h3 class="title">Effettua l'accesso</h3>
          <form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
              <label>email</label>
              <input class="form-control" type="email" name="email" placeholder="email address">
            </div>
            <div class="form-group">
              <label>password</label>
              <input class="form-control" type="password" name="password" placeholder="password">
            </div>
            <button type="submit" class="btn btn-default">Entra</button>
            <a href="registrazione.jsp" class="text-secondary">Registrati ora</a>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>