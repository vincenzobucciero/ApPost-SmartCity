<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>ApPost - Statistiche</title>
  <!-- Include Bootstrap CSS -->
  <!-- Bootstrap Icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- SimpleLightbox plugin CSS-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <link rel="stylesheet" href="CSS/style.css">

  <%
    int[] values = {1,2,3,4};
    request.setAttribute("dataSet", Arrays.toString(values));
  %>

</head>
<body>
<header class="masthead">
  <jsp:include page="NavBarAdmin.jsp" />

  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <div class="col-lg-10 mx-auto mb-4">
          <h2 class="text-center mt-0" style="color: white">Statistiche Ore</h2>
          <hr class="divider" />
        </div>
        <div class="card">
          <div class="container">
            <div class="row">
              <div class="col-sm-12">
                <form class="form-horizontal" style="font-family: Inter" action="ChartHoursServlet" method="post">
                  <div class="form-group row">
                    <div class="col-md-4">
                      <br>
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
                      <br>
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
                      <br>
                      <label name="tipoV">Seleziona Veicolo</label>
                      <select class= "form-control" name="tipoV" required>
                        <option value="">--scegli--</option>
                        <option type="hidden" name="tipoV">Auto</option>
                        <option type="hidden" name="tipoV">Furgone</option>
                        <option type="hidden" name="tipoV">Moto</option>
                      </select>
                    </div>
                    <button type="submit" class="btn btn-outline-primary form-control col-md-4">Ricalcola</button>
                  </div>
                </form>
                <div class="text-center" style="font-family: Inter">
                  <div id="prima" style="color: transparent">${statistiche.get(0)}</div>
                  <a class="text-center text-black">
                    Stai visualizzando la media delle ore effettive di parcheggio del veicolo: <a class="fw-bold text-black">${veicolo}</a> <br>
                  </a>

                  <a class="text-center text-black">
                    Al parcheggio: <a class="fw-bold text-black"> ${park} <br></a>
                  </a>

                  <a class="text-center text-black">
                    Nel mese di: <a class="fw-bold text-black">${meseScelto}</a>.
                  </a>
                  <div id="seconda" style="color: transparent" >${statistiche.get(1)}</div>
                  <div id="terza" style="color: transparent" >${statistiche.get(2)}</div>
                  <div id="quarta" style="color: transparent" >${statistiche.get(3)}</div>
                  <div id="quinta" style="color: transparent" >${statistiche.get(4)}</div>
                </div>
                <canvas id="myChart"></canvas>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>

<header class="masthead"></header>


<!-- Footer-->
<jsp:include page="Footer.jsp" />
<!-- Include Bootstrap JS and Chart.js -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<script src="js/jsCharts.js"></script>

<script>
  function confermaLogout() {
    return confirm("Sei sicuro di voler uscire?");
  }
</script>

</body>
</html>