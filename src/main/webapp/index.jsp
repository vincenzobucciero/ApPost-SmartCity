<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>ApPost</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootstrapmade.com/selecao-bootstrap-template/"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <style>
        .logo {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background-color: green;
            position: absolute;
            top: 15px;
            left: 15px;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-weight: bold;
            font-size: 15px;
            font-style:italic;
        }
        .logo span {
            display: block;
            text-align: center;
        }
        body {
            background: #31343f;
        }
        .brand {
            color: #40ad33;
        }
        .border-hover {
            border-top: 5px solid transparent;
            transform: translateY(-4px);
        }
        .border-hover:hover {
            border-top: 5px solid #40ad33;
            transform: translateY(-4px);
        }
        #sign-in {
            background: #40ad33;
            border-top-left-radius: 50px;
            border-bottom-left-radius: 50px;
        }
        .navbar-toggler {
            border: 1px solid #40ad33;
        }
        .navbar-toggler-icon {
            background-image: url(/static_files/svgs3/list.svg)
        }
        .navbar-toggler:focus {
            box-shadow: none;
        }
        #nav-length {
            width: 40%;
        }
        @media screen and (max-width : 992px) {
            #nav-length {
                width: 100%;
            }
            .border-hover {
                border-top: 0;
            }
            .border-hover:hover {
                border-top: 0;
            }
            #sign-in {
                border-radius: 50px;
            }
        }
        /* body section */
        .icon-height {
            height: 28px;
            width: 28px;
        }
        .icon-container {
            background: #FF9138;
        }
        .dark-background {
            background: #2b3944;
        }
    </style>
</head>
<body>
<nav>
    <div class="navbar navbar-expand-lg pt-4">
        <div class="container-fluid">
            <a href="#" class="brand text-decoration-none d-block d-lg-none fw-bold fs-1 ">LOGO</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <ul id="nav-length" class="navbar-nav justify-content-between border-top border-2 text-center">
                    <li class="nav-item">
                        <a href="descrizioneApp.jsp" class="nav-link border-hover py-3 text-white">Chi siamo</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link border-hover py-3 text-white">Contatti</a>
                    </li>
                    <li class="nav-item">
                        <a href="registrazione.jsp" class="nav-link border-hover py-3 text-white">Registrati</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.jsp" id="sign-in" class="nav-link my-2 px-4 text-white">
                            Entra
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="jumbotron">
        <h1 class="display-4">ApPost</h1>
        <p>Con l'app di parcheggi smart, non dovrai più preoccuparti di cercare un parcheggio.
            Trova il parcheggio più vicino a te, prenotazione e pagamento in completa autonomia,
            e naviga verso la tua destinazione senza stress.</p>
        <hr class="my-4">

        <a class="btn btn-secondary btn-lg ml-2" href="${pageContext.request.contextPath}/registrazione.jsp"
           role="button">Registrati ora</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/login.jsp"
           role="button">Accedi</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<div class>
    <footer class="bg-dark text-center text-white">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2023 Copyright:
            <a class="text-white" href="index.jsp">ApPost.com</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>


</body>
</html>