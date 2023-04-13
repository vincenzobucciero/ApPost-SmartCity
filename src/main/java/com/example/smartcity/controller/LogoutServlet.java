package com.example.smartcity.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * Questa classe è una servlet che gestisce il logout dell'utente dal sistema. Quando l'utente esegue il logout,
 * la sessione viene invalidata, quindi tutti gli attributi presenti nella sessione vengono resi nulli.
 * Dopo il logout, l'utente viene reindirizzato alla homepage del sito.
 */
@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * Questo metodo gestisce una richiesta GET di logout da parte dell'utente.
     * Invalida la sessione se presente e reindirizza l'utente alla homepage del sito.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica una eccezione di tipo servlet
     * @throws IOException se si verifica un errore d'I/O
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if ( session != null ) {

            //invalido la sessione rendendo nulli tutti gli attributi presenti nella sessione
            session.invalidate();
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    /**
     * Questo metodo gestisce una richiesta POST di logout da parte dell'utente. Non viene eseguita alcuna azione.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica una eccezione di tipo servlet
     * @throws IOException se si verifica un errore di I/O
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}