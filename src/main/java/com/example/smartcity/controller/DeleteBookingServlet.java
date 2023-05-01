package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.UserBean;

import com.example.smartcity.model.DAO.BookingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * Questa classe rappresenta una servlet che gestisce la cancellazione di una prenotazione.
 * La classe si occupa di ricevere richieste HTTP POST e, dopo aver effettuato alcuni controlli sulla sessione,
 * recupera l'ID della prenotazione da cancellare tramite il parametro "id" presente nella richiesta HTTP.
 * Successivamente, la classe chiama il metodo "deleteBooking" della classe BookingService, che cancella la prenotazione
 * dal database.
 * Infine, la servlet recupera l'email dell'utente che ha effettuato la richiesta e visualizza una pagina di conferma
 * cancellazione prenotazione.
 */
@WebServlet(name = "DeleteBookingServlet", value = "/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {

    /**
     * Metodo che gestisce le richieste HTTP GET.
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un errore nella gestione della richiesta
     * @throws IOException se si verifica un errore di input/output
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Metodo che gestisce le richieste HTTP POST. Questo metodo si occupa di cancellare la
     * prenotazione e visualizzare una pagina di conferma cancellazione prenotazione.
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un errore nella gestione della richiesta
     * @throws IOException se si verifica un errore di input/output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession( false );

        if ( session == null ) {
            session.setAttribute( "isLog",0 );
            request.getRequestDispatcher( "login.jsp" ).forward(request,response);
        } else {

            String idPrenotazione = request.getParameter( "id" );
            System.out.println( "Cancella: " + idPrenotazione );

            BookingDao.deleteBooking(idPrenotazione);

            String email = request.getParameter("email");

            request.getRequestDispatcher( "cancelPage.jsp" ).forward(request, response);

        }

    }
}