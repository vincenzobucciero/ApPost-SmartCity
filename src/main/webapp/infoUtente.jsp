<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 3/21/23
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ApPost-Smart Parking</title>
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
    <link rel="stylesheet" href="img">
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="index.jsp">ApPost</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link" href="userHomePage.jsp">Torna alla home</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Masthead-->
<header class="masthead">
    <section>
        <div class="row">
            <!-- Riquadro dell'avatar -->
            <div class="col-lg-3 mb-3">
                <div class="card">
                    <div class="card-body text-center">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                             class="rounded-circle img-fluid" style="width: 100px;">
                        <h5 class="my-3">
                            <c:choose>
                                <c:when test="${usersBean != null}">
                                    <p class="text-muted mb-0">
                                            ${usersBean.getNome()} ${usersBean.getCognome()}
                                    </p>
                                </c:when>
                            </c:choose>
                            <p class="text-muted mb-0">Utente</p>
                        </h5>
                    </div>
                </div>
            </div>

            <!-- Riquadro delle informazioni -->
            <div class="col-lg-7 mt-4 mt-lg-0">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Nome</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <c:choose>
                                        <c:when test="${usersBean != null}">
                                            ${usersBean.getNome()}
                                        </c:when>
                                    </c:choose>
                                </p>
                            </div>
                        </div>
                        <hr>

                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Cognome</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <c:choose>
                                        <c:when test="${usersBean != null}">
                                            ${usersBean.getCognome()}
                                        </c:when>
                                    </c:choose>
                                </p>
                            </div>
                        </div>
                        <hr>

                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <c:choose>
                                        <c:when test="${usersBean != null}">
                                            ${usersBean.getEmail()}
                                        </c:when>
                                    </c:choose>
                                </p>
                            </div>
                        </div>
                        <div>
                            <form action="ModifyUserServlet" method="post">
                                <input type="hidden" name="email" value="${usersBean.getEmail()}">
                                <div class="text-center">
                                    <button type="submit" class="btn btn-outline-primary">Modifica</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>



</header>


<!-- Footer-->
<footer class="bg-light py-5">
    <div class="container px-4 px-lg-5"><div class="small text-center text-muted">Copyright &copy; 2023 - Company Name</div></div>
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