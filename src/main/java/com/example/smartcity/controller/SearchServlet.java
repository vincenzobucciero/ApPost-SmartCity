package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 * Questa classe rappresenta la servlet per la ricerca del percorso.
 * Viene invocata quando un utente richiede di visualizzare la pagina per la ricerca del percorso tramite una richiesta GET.
 * Se l'utente è loggato, viene recuperato il relativo UserBean dalla sessione e passato alla pagina findPath.jsp.
 * In caso contrario, viene impostato il parametro isLog a 0 nella sessione e viene reindirizzata la richiesta alla pagina di login.
 * Viene utilizzata anche per ricevere i dati della ricerca effettuata dall'utente tramite una richiesta POST.
 */
@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {

    /**
     * Metodo invocato quando viene effettuata una richiesta GET alla servlet.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene le informazioni sulla richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene le informazioni sulla risposta HTTP
     * @throws ServletException se si verifica un errore durante l'esecuzione della servlet
     * @throws IOException se si verifica un errore d'I/O durante l'esecuzione della servlet
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession( false );
        if ( session == null ) {
            session.setAttribute( "isLog",0 );
            request.getRequestDispatcher( "login.jsp" ).forward(request,response);
        } else {
            request.getRequestDispatcher( "findPath.jsp" ).forward(request,response);
        }

    }


    /**
     * Metodo invocato quando viene effettuata una richiesta POST alla servlet.
     * Non viene utilizzato in questa classe.
     *
     * @param request l'oggetto HttpServletRequest che contiene le informazioni sulla richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene le informazioni sulla risposta HTTP
     * @throws ServletException se si verifica un errore durante l'esecuzione della servlet
     * @throws IOException se si verifica un errore d'I/O durante l'esecuzione della servlet
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}