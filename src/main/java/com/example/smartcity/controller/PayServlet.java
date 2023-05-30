package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;

import com.example.smartcity.service.Strategy.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * Questa servlet gestisce la transazione di pagamento con carta di credito.
 * Riceve i dati della carta di credito dal form di pagamento, effettua il pagamento
 * e in caso di esito positivo aggiunge la prenotazione al database.
 */

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {

    /**
     * Metodo chiamato quando la servlet viene richiamata tramite una richiesta GET.
     * Non fa nulla e restituisce una risposta vuota.
     *
     * @param request la richiesta HTTP ricevuta
     * @param response la risposta HTTP da inviare
     * @throws ServletException se si verifica un errore durante la gestione della richiesta
     * @throws IOException se si verifica un errore d'I/O durante la gestione della richiesta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    /**
     * Metodo chiamato quando la servlet viene richiamata tramite una richiesta POST.
     * Riceve i dati della carta di credito dal form di pagamento, effettua il pagamento
     * e in caso di esito positivo aggiunge la prenotazione al database.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request la richiesta HTTP ricevuta
     * @param response la risposta HTTP da inviare
     * @throws ServletException se si verifica un errore durante la gestione della richiesta
     * @throws IOException se si verifica un errore d'I/O durante la gestione della richiesta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String nome = request.getParameter("intestatario");
        String numeroCarta = request.getParameter("numCarta");
        String cvv = request.getParameter("cvv");
        String meseScadenza = request.getParameter("MM");
        String annoScadenza = request.getParameter("YY");

        String dataScadenza = annoScadenza + "-" + meseScadenza;

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {
            BookingBean bookingBean = ( BookingBean ) session.getAttribute("bookingBean");
            String nomeParcheggio = bookingBean.getNomeParcheggio();
            ParkingBean parkingBean = ParkingDao.getParkingBean(nomeParcheggio);

            PaymentStrategy paymentMethod = new CreditCardStrategy( nome, numeroCarta, cvv, dataScadenza );

            if(paymentMethod.pay(bookingBean.getPrezzo())) {
                session.setAttribute("email", bookingBean.getEmail());
                session.setAttribute("bookingBean", bookingBean);
                session.setAttribute("parkingBean",parkingBean);
                BookingDao.addBooking(bookingBean);

                request.getRequestDispatcher("thankYouPage.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("errorPage.jsp").forward(request,response);
            }

        }

    }
}