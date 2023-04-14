<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 02/04/23
  Time: 12:56
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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <!-- Core theme CSS (includes Bootstrap)-->


  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/stylePrenotazione.css">
  <link rel="stylesheet" type="text/css" href="css/styleMap.css" />
  <link rel="stylesheet" href="css/styleListPark.css">

  <script type="module" src="js/scripts.js"></script>
  <script type="module" src="TySc/tyS.ts"></script>

  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Prenotazione</title>
</head>
<body>

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

<header class="masthead">
  <div class="container">
    <div class="row">
      <div class="col-sm-5">
        <div class="my-5 card bg-light mx-auto" style="width:60rem;">
          <div class="card-body">
            <h5 class="text-muted">
              Questi sono i parcheggi disponibili per il percorso scelto:
            </h5>

            <!-- Qui inizia il div per la lista dei parcheggi-->

            <div class="container mt-5" style="font-family: 'Inter', sans-serif">
              <div class="row">
                <div class="col-md-12">
                  <div class="d-flex justify-content-between align-items-center activity">
                    <div>
                                            <span class="activity-done">
                                                Parcheggi(${size})
                                            </span>
                    </div>
                    <div>
                                            <span class="m-lg-4">
                                                (Da ${start} a ${dest}):
                                            </span>
                    </div>
                    <div class="icons">

                      <i class="bi bi-search"></i>
                      <i class="bi bi-three-dots"></i>
                    </div>
                  </div>
                  <div class="mt-3">
                    <c:forEach items="${parcheggioDisp}" var="record"> <!--Ciclo FOR -->
                      <ul class="list list-inline">
                        <li class="d-flex justify-content-between">
                          <div class="d-flex flex-row align-items-center">
                            <div class="ml-3">
                              <h6 class="mb-0">
                                <td>
                                    ${record.getNomeParcheggio()}
                                </td>
                              </h6>
                              <div class="d-flex flex-row mt-1 text-black-50 date-time">
                                                            <span class="ml-2"> <!--22 May 2023-->
                                                                <i class="bi bi-geo-fill" style="color: #b60909"></i>
                                                                <td>
                                                                    ${record.getIndirizzo()}<br>
                                                                    <i class="fas fa-car-side"></i>/<i class="fas fa-truck"></i>
                                                                    ${record.getTariffaAF()}€/h <br>
                                                                    <i class="fas fa-motorcycle"></i>
                                                                    ${record.getTariffaM()}€/h
                                                                </td>
                                                            </span>
                              </div>
                            </div>
                          </div>
                          <div class="d-flex flex-row align-items-center">
                            <div class="d-flex flex-column mr-2">
                              <div class="profile-image">
                                <form action="BookingServlet" method="get">
                                  <input type="hidden" name="nomeP" value="${record.getNomeParcheggio()}">
                                  <input type="hidden" name="email" value="${userBean.getEmail()}">

                                  <div class="text-center">
                                    <button type="submit" class="btn btn-primary btn-sm ">Prenota</button>
                                  </div>
                                </form>
                              </div>
                            </div>
                          </div>
                        </li>
                      </ul>
                    </c:forEach>
                  </div>
                </div>
              </div>
            </div>
            <!--Qui finisce il div per la lista dei parcheggi -->
          </div>
        </div>
      </div>
    </div>
  </div>
</header>

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