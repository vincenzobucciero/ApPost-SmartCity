package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;

import com.example.smartcity.model.DAO.BookingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Questa classe rappresenta una servlet per mostrare le prenotazioni dell'utente loggato.
 */
@WebServlet(name = "ShowBookingServlet", value = "/ShowBookingServlet")
public class ShowBookingServlet extends HttpServlet {

    /**
     * Gestisce una richiesta GET alla servlet. Non viene eseguito alcun tipo di elaborazione
     * poiché le prenotazioni devono essere mostrate solo se si riceve una richiesta POST.
     * @param request La richiesta HTTP ricevuta.
     * @param response La risposta HTTP da inviare.
     * @throws ServletException Se si verifica un errore nella gestione della richiesta.
     * @throws IOException Se si verifica un errore d'input/output.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Gestisce una richiesta POST alla servlet. Recupera l'email dell'utente dalla richiesta
     * e richiama il metodo getBooking della classe BookingDao, che restituisce la lista di
     * prenotazioni effettuate dall'utente. Se la sessione non esiste o non è valida, l'utente
     * viene reindirizzato alla pagina di login.
     * @param request La richiesta HTTP ricevuta.
     * @param response La risposta HTTP da inviare.
     * @throws ServletException Se si verifica un errore nella gestione della richiesta.
     * @throws IOException Se si verifica un errore d'input/output.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            String email = request.getParameter("email");

            List<BookingBean> list = BookingDao.getBooking(email);

            int size = list.size();

            session.setAttribute( "email", email);
            session.setAttribute("list", list);

            request.getRequestDispatcher("showBooking.jsp").forward(request, response);

        }

    }
}