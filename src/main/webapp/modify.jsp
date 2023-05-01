<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 18/03/23
  Time: 17:05
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
                        <li class="nav-item"><a class="nav-link" href="adminHomePage.jsp">Torna alla Home</a></li>
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
                              <c:when test="${parkingBean != null}">
                                    <div class="col-md-4 col-md-offset-4">
                                          <div class="form-container">
                                                <h3 class="title">
                                                      <svg fill="#ff6a00" height="100px" width="100px" style="position: center" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="-117.76 -117.76 747.53 747.53" xml:space="preserve"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <g> <g> <g> <path d="M437.024,74.984c-8.331-8.331-21.839-8.331-30.17,0s-8.331,21.839,0,30.17c83.317,83.317,83.317,218.394,0.002,301.69 c-8.332,8.33-8.334,21.838-0.003,30.17c8.33,8.332,21.838,8.334,30.17,0.003C537.004,337.059,537.004,174.964,437.024,74.984z"></path> <path d="M105.153,105.165c8.332-8.33,8.334-21.838,0.003-30.17c-8.33-8.332-21.838-8.334-30.17-0.004 c-99.981,99.958-99.981,262.054-0.002,362.033c8.331,8.331,21.839,8.331,30.17,0c8.331-8.331,8.331-21.839,0-30.17 C21.838,323.538,21.838,188.46,105.153,105.165z"></path> <path d="M256.004,85.338c-94.257,0-170.667,76.41-170.667,170.667s76.41,170.667,170.667,170.667s170.667-76.41,170.667-170.667 S350.261,85.338,256.004,85.338z M256.004,384.004c-70.693,0-128-57.307-128-128s57.307-128,128-128s128,57.307,128,128 S326.697,384.004,256.004,384.004z"></path> <path d="M277.338,149.338h-42.667c-11.782,0-21.333,9.551-21.333,21.333v85.333v85.333c0,11.782,9.551,21.333,21.333,21.333 c11.782,0,21.333-9.551,21.333-21.333v-64h21.333c35.355,0,64-28.645,64-64S312.693,149.338,277.338,149.338z M277.338,234.671 h-21.333v-42.667h21.333c11.791,0,21.333,9.542,21.333,21.333S289.129,234.671,277.338,234.671z"></path> </g> </g> </g> </g></svg>
                                                </h3>
                                                <form class="form-horizontal" action="ModifyServlet" method="post">
                                                      <div class="form-group row">
                                                            <div class="col-md-4">
                                                                  <label name="nome">Nome parcheggio:</label>
                                                                  <input type="text" class="form-control text-muted" name="nome" value="${parkingBean.getNomeParcheggio()}" readonly><br />
                                                            </div>
                                                            <div class="col-md-4">
                                                                  <label name="indirizzo">Indirizzo:</label>
                                                                  <input type="text" class="form-control" name="indirizzo" value="${parkingBean.getIndirizzo()}"><br />
                                                            </div>
                                                      </div>
                                                      <div class="form-group row">
                                                            <div class="col-md-4">
                                                                  <label name="tariffaAF">Tariffa Auto/Furgone:</label>
                                                                  <input type="number" class="form-control" id="tariffaAF" name="tariffaAF" value="${parkingBean.getTariffaAF()}">
                                                            </div>
                                                            <div class="col-md-4">
                                                                  <label name="tariffaM">Tariffa Moto:</label>
                                                                  <input type="number" class="form-control" id="tariffaM" name="tariffaM" value="${parkingBean.getTariffaM()}">
                                                            </div>
                                                      </div>
                                                      <div class="form-group row">
                                                            <div class="col-md-4">
                                                                  <label name="numPosti">Posti Auto:</label>
                                                                  <input type="postiAuto" class="form-control" id="postiAuto" name="postiAuto"value="${parkingBean.getPostiAuto()}">
                                                            </div>
                                                            <div class="col-md-4">
                                                                  <label name="numPosti">Posti Furgone:</label>
                                                                  <input type="postiFurgone" class="form-control" id="postiFurgone" name="postiFurgone"value="${parkingBean.getPostiFurgone()}">
                                                            </div>
                                                            <div class="col-md-4">
                                                                  <label name="numPosti">Posti Moto:</label>
                                                                  <input type="postiMoto" class="form-control" id="postiMoto" name="postiMoto"value="${parkingBean.getPostiMoto()}">
                                                            </div>
                                                      </div>
                                                      <input type="hidden" name="nomeparking" value="${parkingBean.getNomeParcheggio()}" >
                                                      <button  type="submit" class="btn btn-primary btn-lg text-light "> Modifica </button>
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
