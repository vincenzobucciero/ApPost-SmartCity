package com.example.smartcity.controller;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ParkingService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * La classe InfoParkingServlet gestisce la richiesta POST d'informazioni relative a un parcheggio.
 * Questa servlet riceve i dati relativi al parcheggio da modificare dal client tramite una richiesta POST e,
 * dopo aver verificato la sessione dell'utente, utilizza il servizio ParkingService
 * per recuperare l'oggetto ParkingBean corrispondente al parcheggio richiesto.
 * L'oggetto ParkingBean viene quindi passato come attributo alla richiesta per la successiva
 * visualizzazione delle informazioni di modifica del parcheggio.
 */

@WebServlet(name = "InfoParkingServlet", value = "/InfoParkingServlet")
public class InfoParkingServlet extends HttpServlet {

    /**
     * Gestisce la richiesta GET d'informazioni relative a un parcheggio.
     * Questo metodo viene utilizzato solo per ottenere informazioni sulla servlet stessa,
     * ma in questo caso non viene utilizzato per eseguire nessuna azione.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta del client
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server
     * @throws ServletException se si verifica un errore di servlet
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Gestisce la richiesta POST d'informazioni relative a un parcheggio.
     * Questo metodo riceve i dati del parcheggio da modificare dal client,
     * verifica la sessione dell'utente e recupera l'oggetto ParkingBean corrispondente al parcheggio richiesto
     * tramite il servizio ParkingService. Infine, l'oggetto ParkingBean viene passato
     * come attributo alla richiesta per la visualizzazione delle informazioni di modifica del parcheggio.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta del client
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server
     * @throws ServletException se si verifica un errore di servlet
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            String nomeParcheggio = request.getParameter("nomeparking");
            ParkingBean parkingBean = ParkingService.getParkingBean(nomeParcheggio);

            parkingBean.setNomeParcheggio(nomeParcheggio);

            request.setAttribute("parkingBean", parkingBean);
            request.getRequestDispatcher("modify.jsp").forward(request, response);

        }
    }


}