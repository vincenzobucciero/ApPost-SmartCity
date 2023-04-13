package com.example.smartcity.controller;

import com.example.smartcity.service.ModifyService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * La classe ModifyServlet implementa la funzionalità di modifica di un parcheggio attraverso
 * l'utilizzo dei metodi di ModifyService. Viene richiamata mediante una richiesta HTTP POST e riceve come
 * parametri del body le informazioni relative alla modifica del parcheggio.
 * In caso di successo nella modifica delle informazioni,
 * l'utente viene reindirizzato alla pagina confermaModificaP.jsp .
 * Se la sessione non è valida, l'utente viene reindirizzato alla pagina di login.
 */
@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {

    /**
     * Questo metodo viene richiamato quando viene effettuata una richiesta HTTP GET.
     * Non viene utilizzato in questa implementazione.
     * @param request L'oggetto HttpServletRequest che contiene la richiesta HTTP del client.
     * @param response L'oggetto HttpServletResponse che contiene la risposta HTTP al client.
     * @throws ServletException Se si verifica un errore nella servlet.
     * @throws IOException Se si verifica un errore di input o output.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Questo metodo viene richiamato quando viene effettuata una richiesta HTTP POST.
     * Riceve come parametri del body le informazioni relative alla modifica del parcheggio e utilizza i metodi di ModifyService
     * per modificare le informazioni del parcheggio.
     * In caso di successo, l'utente viene reindirizzato alla pagina confermaModificaP.jsp .
     * Se la sessione non è valida, l'utente viene reindirizzato alla pagina di login.
     *
     * @param request L'oggetto HttpServletRequest che contiene la richiesta HTTP del client.
     * @param response L'oggetto HttpServletResponse che contiene la risposta HTTP al client.
     * @throws ServletException Se si verifica un errore nella servlet.
     * @throws IOException Se si verifica un errore d'input o output.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            String nome = request.getParameter("nomeparking");
            String indirizzo = request.getParameter("indirizzo");
            String tariffaAF = request.getParameter("tariffaAF");
            String tariffaM = request.getParameter("tariffaM");
            String postiAuto = request.getParameter("postiAuto");
            String postiFurgone = request.getParameter("postiFurgone");
            String postiMoto = request.getParameter("postiMoto");

            ModifyService.modifyIndirizzo(nome, indirizzo);
            ModifyService.modifyTariffaAF(nome, Double.parseDouble(tariffaAF));
            ModifyService.modifyTariffaM(nome, Double.parseDouble(tariffaM));
            ModifyService.modifyPostiAuto(nome, Integer.parseInt(postiAuto));
            ModifyService.modifyPostiFurgone(nome, Integer.parseInt(postiFurgone));
            ModifyService.modifyPostiMoto(nome, Integer.parseInt(postiMoto));


            request.getRequestDispatcher("confermaModificaP.jsp").forward(request, response);
        }

    }
}