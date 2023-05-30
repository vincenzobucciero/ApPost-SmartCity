<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 19/03/23
  Time: 12:09
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
    <title>ApPost-Home Page</title>
    <!-- Bootstrap Icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- SimpleLightbox plugin CSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="img">

</head>
<body>
<!-- Navigation-->
<jsp:include page="NavBarAdmin.jsp" />

<header class="masthead">
    <div class="col-lg-10 mx-auto mb-4">
        <h2 class="text-center mt-0" style="color: white">Gestione</h2>
        <hr class="divider" />
    </div>
    <!--INIZIO SEZIONE CARD-->
    <div class="row">
        <!-- Inizio Prima Card-->
        <div class="my-3 card bg-light mx-auto d-flex flex-row" style="width: 50rem;height: 15rem">
            <img style="border-radius: 2.3rem; max-width: 50%" src="img/park2.jpg" class="flex-column">
            <div class="card-body flex-column">
                <h4 class="card-title">Parcheggi</h4>
                <p class="card-text">Viene visualizzata la lista dei parcheggi con le proprie informazioni.</p>
                <form action="ShowParkingServlet" method="post">
                    <button class="btn btn-primary text-center">Visualizza parcheggi</button>
                </form>
            </div>
        </div><!-- Fine Prima Card-->

        <!-- Inizio Seconda Card-->
        <div class="my-3 card bg-light mx-auto d-flex flex-row" style="width: 50rem;height: 16rem">
            <img style="border-radius: 2.3rem; max-width: 45%" src="img/statistiche.jpg" class="flex-column">
            <div class="card-body flex-column">
                <form action="ChartsServlet" method="get">
                    <h4 class="card-title">Statistiche</h4>
                    <p class="card-text">Potrai vedere le statistiche relative a ogni mese e per ogni parcheggio</p>
                    <button class="btn btn-primary text-center text-light">Statistiche accessi</button>
                </form>
                <form action="ChartHoursServlet" method="get">
                    <button class="btn btn-primary text-center text-light">Statistiche ore</button>
                </form>

            </div>
        </div><!-- Fine Seconda Card-->

        <!-- Inizio Terza Card-->
        <div class="my-3 card bg-light mx-auto d-flex flex-row" style="width: 50rem;height: 15rem">
            <img style="border-radius: 2.3rem; max-width: 45%" src="img/booking.jpg" class="flex-column">
            <div class="card-body flex-column">

                <h4 class="card-title">Prenotazioni</h4>
                <p class="card-text">Qui vengono visualizzate le prenotazioni effettuate,
                    con informazioni come data orario e luogo.</p>
                <form action="ShowBookingServlet" method="post">
                    <button class="btn btn-primary">Visualizza prenotazioni</button>
                </form>
            </div>
        </div><!-- Fine Seconda Card-->
    </div><!-- FINE SEZIONE CARD-->
</header>

<header class="masthead">
</header>

<!-- Footer-->
<jsp:include page="Footer.jsp" />


<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

<script src="js/scripts.js"></script>

<script>
    function confermaLogout() {
        return confirm("Sei sicuro di voler uscire?");
    }
</script>

</body>
</html>