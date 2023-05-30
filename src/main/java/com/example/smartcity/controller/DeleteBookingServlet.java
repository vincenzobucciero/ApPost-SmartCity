package com.example.smartcity.controller;

import com.example.smartcity.model.DAO.BookingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.example.smartcity.model.Bean.UserBean;

/**
 * La seguente classe rappresenta una servlet che gestisce la cancellazione di una prenotazione.
 * La classe si occupa di ricevere richieste HTTP POST e, dopo aver effettuato alcuni controlli sulla sessione,
 * recupera l'ID della prenotazione da cancellare tramite il parametro "id" presente nella richiesta HTTP.
 * Successivamente, la classe chiama il metodo "deleteBooking" della classe BookingDao,
 * che cancella la prenotazione dal database. Infine, la servlet recupera l'email dell'utente che ha effettuato
 * la richiesta e visualizza una pagina di conferma cancellazione prenotazione.
 */

@WebServlet(name = "DeleteBookingServlet", value = "/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {

    /**
     * Metodo che gestisce le richieste HTTP GET.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un errore nella gestione della richiesta
     * @throws IOException se si verifica un errore d'input/output
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }




    /**
     * Metodo che gestisce le richieste HTTP POST. Questo metodo si occupa di cancellare la
     * prenotazione e visualizzare una pagina di conferma cancellazione prenotazione.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un errore nella gestione della richiesta
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession( false );

        // Verifica se la sessione esiste
        if ( session == null ) {
            // Imposta il parametro "isLog" a 0
            session.setAttribute( "isLog",0 );
            // Reindirizza l'utente alla pagina di login
            request.getRequestDispatcher( "login.jsp" ).forward(request,response);
        } else {
            // Recupera l'ID della prenotazione da cancellare tramite il parametro "id" presente nella richiesta HTTP
            String idPrenotazione = request.getParameter( "id" );

            // Chiama il metodo "deleteBooking" della classe BookingDao per cancellare la prenotazione dal database
            BookingDao.deleteBooking( idPrenotazione );

            // Recupera l'email dell'utente che ha effettuato la richiesta
            String email = request.getParameter("email");

            // Controlla se è un amministratore o meno
            if (email.equals("admin@admin.com")){
                // Visualizza una pagina di conferma cancellazione prenotazione
                request.getRequestDispatcher("cancelPageAdmin.jsp").forward(request,response);
            }
            else {
                // Visualizza una pagina di conferma cancellazione prenotazione
                request.getRequestDispatcher("cancelPage.jsp").forward(request, response);
            }

        }

    }
}