package com.example.smartcity.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * La servlet LogoutServlet si occupa della gestione della richiesta di logout degli utenti.
 * In particolare, invalida la sessione dell'utente e reindirizza alla homepage del sito.
 */
@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * Questo metodo gestisce la richiesta HTTP GET e invalida la sessione dell'utente,
     * rendendo nulli tutti gli attributi presenti nella sessione.
     * In seguito, reindirizza alla homepage del sito.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta del client.
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server.
     * @throws ServletException se la richiesta non può essere gestita.
     * @throws IOException se si verifica un errore d'I/O mentre si gestisce la richiesta.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if ( session != null ) {
            session.invalidate(); // invalido la sessione rendendo nulli tutti gli attributi presenti nella sessione
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }


    /**
     * Questo metodo gestisce la richiesta HTTP POST e non fa nulla, in quanto la richiesta di logout
     * è gestita con una richiesta HTTP GET.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta del client.
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server.
     * @throws ServletException se la richiesta non può essere gestita.
     * @throws IOException se si verifica un errore d'I/O mentre si gestisce la richiesta.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}