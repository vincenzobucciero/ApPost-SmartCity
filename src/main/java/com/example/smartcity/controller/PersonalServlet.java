package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * La classe PersonalServlet implementa una servlet responsabile della gestione della pagina
 * delle informazioni personali dell'utente.
 */

@WebServlet(name = "PersonalServlet", value = "/PersonalServlet")
public class PersonalServlet extends HttpServlet {

    /**
     * Questo metodo viene chiamato quando la pagina delle informazioni personali
     * dell'utente viene richiesta tramite una richiesta GET.
     * Controlla se l'utente ha effettuato l'accesso e in seguito inoltra la richiesta alla pagina "infoUtente.jsp".
     * Se l'utente non ha effettuato l'accesso, il metodo imposta l'attributo di sessione "isLog" a 0
     * e inoltra la richiesta alla pagina "login.jsp".
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException  se la richiesta non può essere gestita
     * @throws IOException se viene rilevato un errore di input o output quando la servlet gestisce la richiesta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("infoUtente.jsp").forward(request,response);
        }
    }

    /**
     * Questo metodo viene chiamato quando le informazioni personali
     * dell'utente vengono aggiornate tramite una richiesta POST.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException se la richiesta non può essere gestita
     * @throws IOException se viene rilevato un errore di input o output quando la servlet gestisce la richiesta
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}