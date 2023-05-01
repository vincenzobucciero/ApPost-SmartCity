<%--
  Created by IntelliJ IDEA.
  User: vincenzo
  Date: 5/1/23
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Statistiche</title>
  <!-- Include Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">

  <%
    int[] values = {1,2,3,4};
    request.setAttribute("dataSet", Arrays.toString(values));
  %>

</head>
<body>
<header class="masthead">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container px-4 px-lg-5">
      <a class="navbar-brand" href="index.jsp">ApPost</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
              aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ms-auto my-2 my-lg-0">
          <li class="nav-item"><a class="nav-link" href="adminHomePage.jsp">Torna alla home</a></li>
          <li class="nav-item"><a class="nav-link" href="logout">Esci</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <div class="col-lg-10 mx-auto mb-4">
          <h2 class="text-center mt-0" style="color: white">Statistiche</h2>
          <hr class="divider" />
        </div>
        <div class="card">
          <div class="container">
            <div class="row">
              <div class="col-sm-12">
                <form class="form-horizontal" action="ChartsServlet" method="post">
                  <div class="form-group row">
                    <div class="col-md-4">
                      <label name="tipoV">Seleziona Parcheggio</label>
                      <select class= "form-control" name="parcheggio" required>
                        <option value="">--scegli--</option>
                        <c:forEach items="${list}" var="record"> <!--Ciclo FOR -->
                          <option type="hidden" name="parcheggio">
                            <td>
                                ${record.getNomeParcheggio()}
                            </td>
                          </option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label name="tipoV">Seleziona mese</label>
                      <select class= "form-control" name="mese" required>
                        <option value="">--scegli--</option>
                        <option type="hidden" name="mese" value="january">Gennaio</option>
                        <option type="hidden" name="mese" value="february">Febbraio</option>
                        <option type="hidden" name="mese" value="march">Marzo</option>
                        <option type="hidden" name="mese" value="april">Aprile</option>
                        <option type="hidden" name="mese" value="may">Maggio</option>
                        <option type="hidden" name="mese" value="june">Giugno</option>
                        <option type="hidden" name="mese" value="july">Luglio</option>
                        <option type="hidden" name="mese" value="august">Agosto</option>
                        <option type="hidden" name="mese" value="september">Settembre</option>
                        <option type="hidden" name="mese" value="october">Ottobre</option>
                        <option type="hidden" name="mese" value="november">Novembre</option>
                        <option type="hidden" name="mese" value="december">Dicembre</option>
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label name="tipoV">Seleziona Veicolo</label>
                      <select class= "form-control" name="tipoV" required>
                        <option value="">--scegli--</option>
                        <option type="hidden" name="tipoV">Auto</option>
                        <option type="hidden" name="tipoV">Furgone</option>
                        <option type="hidden" name="tipoV">Moto</option>
                      </select>
                    </div>
                    <button type="submit" class="col-md-4" >Ricalcola</button>
                  </div>
                </form>
                <div id="prima" style="color: transparent" >${statistiche.get(0)}</div>
                <div id="seconda" style="color: transparent" >${statistiche.get(1)}</div>
                <div id="terza" style="color: transparent" >${statistiche.get(2)}</div>
                <div id="quarta" style="color: transparent" >${statistiche.get(3)}</div>
                <div id="quinta" style="color: transparent" >${statistiche.get(4)}</div>
                <canvas id="myChart"></canvas>
              </div>
            </div>
          </div>
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
<!-- Include Bootstrap JS and Chart.js -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<script src="js/jsCharts.js"></script>

</body>
</html>