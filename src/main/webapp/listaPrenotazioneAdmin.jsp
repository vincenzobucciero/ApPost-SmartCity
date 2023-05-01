<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 5/1/23
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>ApPost-Prenotazioni</title>
  <!-- Bootstrap Icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- SimpleLightbox plugin CSS-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

  <!-- Core theme CSS (includes Bootstrap)-->
  <link rel="stylesheet" href="css/styleAdmin.css">
  <style>
    <%@include file="vendor/datatables/dataTables.bootstrap4.css"%>
    .sorting_asc{
      color: #f4623a !important;
    }

    table.dataTable > thead .sorting:before, table.dataTable > thead .sorting:after, table.dataTable > thead .sorting_asc:before, table.dataTable > thead .sorting_asc:after, table.dataTable > thead .sorting_desc:before, table.dataTable > thead .sorting_desc:after, table.dataTable > thead .sorting_asc_disabled:before, table.dataTable > thead .sorting_asc_disabled:after, table.dataTable > thead .sorting_desc_disabled:before, table.dataTable > thead .sorting_desc_disabled:after {
      position: absolute;
      bottom: 0.5em!important;
      display: block;
      opacity: 0.3;
    }

    table.dataTable > thead .sorting:before, table.dataTable > thead .sorting_asc:before, table.dataTable > thead .sorting_desc:before, table.dataTable > thead .sorting_asc_disabled:before, table.dataTable > thead .sorting_desc_disabled:before {
      right: 0.5em;
      content: ""!important;
    }

    table.dataTable > thead .sorting:after, table.dataTable > thead .sorting_asc:after, table.dataTable > thead .sorting_desc:after, table.dataTable > thead .sorting_asc_disabled:after, table.dataTable > thead .sorting_desc_disabled:after {
      right: 0.5em;
      content: ""!important;
    }

    div.dataTables_wrapper div.dataTables_length select {
      width: 3.5rem;
      display: inline-block;
    }
  </style>


  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="img"></head>
<body>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="index.jsp">ApPost</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto my-2 my-lg-0">
        <li class="nav-item"><a class="nav-link" href="homepage">Torna alla home</a></li>
        <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Masthead-->
<header class="masthead">
  <div class="container">
    <!-- Page Heading -->
    <div class="row">
      <div class="col-lg-10 mx-auto mb-3">
        <h2 class="text-center mt-0" style="color: white">Prenotazioni Totali</h2>
        <hr class="divider"/>
      </div>
      </h4>
    </div>
    <!-- DataTales -->
    <div class="card shadow mb-4">
      <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Prenotazioni</h6>
      </div>
      <div class="card-body">
        <div class="table-responsive">
          <table class="table table-bordered" id="dataTable" style="width: 100%">
            <thead>
            <tr>
              <th>Id</th>
              <th>Email</th>
              <th>Parcheggio</th>
              <th>Veicolo</th>
              <th>Data</th>
              <th>Orario</th>
              <th>Prezzo</th>
              <th>Pagamento</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="record" items="${list1}">
              <tr>
                <td>${record.getID_prenotazione()}</td>
                <td>${record.getEmail()}</td>
                <td>${record.getNomeParcheggio()}</td>
                <td>${record.getTipoVeicolo()} (${record.getTargaVeicolo()})</td>
                <td>${record.getData_prenotazione()}</td>
                <td>${record.getOrario_inizio()}-${record.getOrario_fine()}</td>
                <td>${record.getPrezzo()}€</td>
                <td>${record.getPagamento()} <i style="color:#11cc11;" class="bi bi-check-circle-fill"></i></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</header>

<header class="masthead">

</header>

<!-- Footer-->
<footer class="bg-light py-5">
  <div class="container px-4 px-lg-5"><div class="small text-center text-muted">Copyright &copy; 2023 - ApPost</div></div>
</footer>

<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>

<!-- Custom scripts for all pages-->
<script><%@include file="js/sb-admin-2.js"%></script>

<!-- Core plugin JavaScript-->
<script><%@include file="vendor/jquery-easing/jquery.easing.min.js"%></script>


<!-- Page level plugins -->
<script><%@include file="vendor/datatables/jquery.dataTables.min.js"%></script>
<script><%@include file="vendor/datatables/dataTables.bootstrap4.min.js"%></script>

<!-- Page level custom scripts -->
<script><%@include file="js/demo/datatables-demo.js"%></script>



</body>
</html>