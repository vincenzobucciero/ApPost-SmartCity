<%--
  Created by IntelliJ IDEA.
  User: carmine
  Date: 05/04/23
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <link rel="icon" type="image/x-icon" href="img/wallpaperCar.jpg" />
  <!-- Bootstrap Icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- Google fonts-->
  <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
  <!-- SimpleLightbox plugin CSS-->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link rel="stylesheet" href="CSS/style.css">
  <link rel="stylesheet" href="CSS/styleCancel.css">


  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

  <link rel="stylesheet" href="img">

  <title>ApPost - Cancellazione Prenotazione</title>
</head>

<body>

<!--Navigation-->
<jsp:include page="NavBarUser.jsp" />

<!--Masthead-->
<header class="masthead">
  <div class="border border-3 border-success"></div>
  <div class="card  bg-white shadow p-5">
    <div class="mb-4 text-center">
      <svg xmlns="http://www.w3.org/2000/svg" width="75" height="75" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
        <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
        <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
      </svg>
    </div>
    <div class="text-center">
      <h1>Hai annullato la tua prenotazione</h1>
      <p>La sua prenotazione è stata correttamente annullata, ci auguriamo di
        rivederti presto presso i nostri parcheggi,</p>
      <div>
        <form action="ShowBookingServlet" method="post">
          <input type="hidden" name="email" value="${email}">
          <button class="btn btn-outline-warning">Visualizza prenotazioni</button>
        </form>
        <form action="AdminServlet" method="post">
          <input type="hidden" name="email" value="${email}">
          <div class="text-center">
            <button class="btn btn-outline-warning" href="adminHomePage.jsp">Torna alla Home</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</header>


<!-- Footer-->
<jsp:include page="Footer.jsp" />


<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

<script>
  function confermaLogout() {
    return confirm("Sei sicuro di voler uscire?");
  }
</script>

</body>
</html>