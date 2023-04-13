package com.example.smartcity.controller;

import com.example.smartcity.model.*;
import com.example.smartcity.service.BookingService;
import com.example.smartcity.service.ParkingService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

/**
 * La classe BookingServlet gestisce la prenotazione del parcheggio da parte degli utenti.
 * L'utente può effettuare una prenotazione inserendo i dettagli della prenotazione come nome del parcheggio,
 * email, data, orario d'inizio e fine, targa e tipo di veicolo e metodo di pagamento.
 * La classe contiene un metodo doGet e un metodo doPost per permettere la gestione di richieste HTTP GET e POST rispettivamente.
 * Il metodo doGet preleva i dettagli del parcheggio da prenotare e, se l'utente è autenticato,
 * lo reindirizza alla pagina di prenotazione.
 * Il metodo doPost preleva i dettagli della prenotazione e li salva nel database,
 * reindirizzando l'utente alla pagina di conferma della prenotazione.
 */

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {

    /**
     * Metodo doGet che viene chiamato quando l'utente richiede la pagina di prenotazione.
     * Il metodo prende i parametri della richiesta come email e nome del parcheggio e
     * se l'utente è autenticato lo reindirizza alla pagina di prenotazione.
     *
     * @param request la richiesta HTTP fatta dall'utente
     * @param response la risposta HTTP da inviare all'utente
     * @throws ServletException in caso di errore nella gestione della richiesta
     * @throws IOException in caso di errore nella gestione della risposta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String nomeParcheggio = request.getParameter("nomeP");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            request.setAttribute( "email", email);
            request.setAttribute("nomeP", nomeParcheggio);
            request.getRequestDispatcher("prenotazione.jsp").forward(request, response);
        }
    }


    /**
     * Metodo doPost che viene chiamato quando l'utente conferma la prenotazione del parcheggio.
     * Il metodo prende i dettagli della prenotazione come nome del parcheggio, email, data, orario d'inizio e fine,
     * targa e tipo di veicolo e metodo di pagamento, e li salva nel database.
     * Successivamente, l'utente viene reindirizzato alla pagina di conferma della prenotazione.
     *
     * @param request la richiesta HTTP fatta dall'utente
     * @param response la risposta HTTP da inviare all'utente
     * @throws ServletException in caso di errore nella gestione della richiesta
     * @throws IOException in caso di errore nella gestione della risposta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeParcheggio = request.getParameter("nomeP");
        ParkingBean parkingBean = ParkingService.getParkingBean(nomeParcheggio);

        String email = request.getParameter("email");
        String dataPrenotazione = request.getParameter("dataP");
        String orarioInizio = request.getParameter("oraI");
        String orarioFine = request.getParameter("oraF");
        String targaVeicolo = request.getParameter("targa");
        String tipoVeicolo = request.getParameter("tipoV");
        String metodoP = request.getParameter("sceltaP");

        String idBooking = RandomStringUtils.randomAlphabetic(7);

        HttpSession session = request.getSession(false);

        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            BookingBean bookingBean = new BookingBean();
            bookingBean.setID_prenotazione(idBooking);
            bookingBean.setData_prenotazione( dataPrenotazione );
            bookingBean.setOrario_inizio( orarioInizio );
            bookingBean.setOrario_fine( orarioFine );
            bookingBean.setTargaVeicolo( targaVeicolo );
            bookingBean.setTipoVeicolo( tipoVeicolo );
            bookingBean.setEmail( email );
            bookingBean.setPagamento( metodoP );
            bookingBean.setNomeParcheggio( nomeParcheggio );


            switch (tipoVeicolo){
                case "Auto":
                    bookingBean.setPrezzo(parkingBean.getTariffaAF());
                    break;
                case "Furgone":
                    bookingBean.setPrezzo(parkingBean.getTariffaAF());
                    break;
                case "Moto":
                    bookingBean.setPrezzo(parkingBean.getTariffaM());
                    break;
                default:
                    break;
            }


            System.out.println("pagamento: " + metodoP);
            switch (metodoP){
                case "Carta di Credito/PayPal":
                    session.setAttribute("bookingBean", bookingBean);
                    request.getRequestDispatcher("pagamento.jsp").forward(request, response);
                    break;
                case "Al parcheggio":
                    BookingService.Booking(bookingBean);
                    session.setAttribute("bookingBean", bookingBean);
                    session.setAttribute("email", bookingBean.getEmail());

                    request.getRequestDispatcher("thankYouPage.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }
    }
}