<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 11/04/23
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>ApPost-Modifica Dati Parcheggio</title>
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
        <li class="nav-item"><a class="nav-link" href="userHomePage.jsp">Torna alla Home</a></li>
        <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
      </ul>
    </div>
  </div>
</nav>


<!-- Masthead-->
<header class="masthead">
  <div class="form-bg">
    <div class="container">
      <div class="row">
        <c:choose>
          <c:when test="${userBean != null}">
            <div class="col-md-4 col-md-offset-4">
              <div class="form-container">
                <h3 class="title">
                  Modifica i tuoi dati
                </h3>
                <form class="form-horizontal" action="ModifyUserServlet" method="post">
                  <div class="form-group row">
                    <div class="col-md-4">
                      <label name="nome">Nome:</label>
                      <input type="text" class="form-control" name="nome" value="${userBean.getNome()}"><br />
                    </div>
                    <div class="col-md-4">
                      <label name="indirizzo">Cognome:</label>
                      <input type="text" class="form-control" name="cognome" value="${userBean.getCognome()}"><br />
                    </div>
                  </div>
                  <div class="form-group">
                    <label name="tariffaAF">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${userBean.getEmail()}" readonly >
                  </div>
                  <div class="form-group">
                    <label name="tariffaAF">Password</label>
                    <input type="text" class="form-control" id="password" name="password" value="${userBean.getPassword()}">
                  </div>
                  <div class="form-group">
                    <input type="hidden" name="email" value="${userBean.getEmail()}" >
                    <button  type="submit" class="btn btn-primary btn-lg"> Modifica </button>
                  </div>
                </form>
              </div>
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
      Copyright &copy; 2022 - Company Name
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
