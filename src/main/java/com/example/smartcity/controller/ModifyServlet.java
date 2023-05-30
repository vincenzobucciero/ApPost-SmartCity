package com.example.smartcity.controller;

import com.example.smartcity.model.DAO.ModifyDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * La servlet "ModifyServlet" è responsabile per la modifica dei dati di un parcheggio.
 * Quando l'utente compila e invia il form di modifica del parcheggio, i dati vengono inviati al server attraverso
 * una richiesta HTTP POST. La servlet riceve la richiesta POST e recupera i dati del
 * parcheggio che sono stati inseriti dal form.
 */

@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {

    /**
     * Metodo che gestisce una richiesta HTTP GET alla servlet.
     * @param request l'oggetto HttpServletRequest che contiene le informazioni della richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene le informazioni per la risposta HTTP
     * @throws ServletException in caso di eccezione durante l'esecuzione della servlet
     * @throws IOException in caso di eccezione durante la gestione della richiesta HTTP
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    /**
     * Metodo che gestisce una richiesta HTTP POST alla servlet.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene le informazioni della richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene le informazioni per la risposta HTTP
     * @throws ServletException in caso di eccezione durante l'esecuzione della servlet
     * @throws IOException in caso di eccezione durante la gestione della richiesta HTTP
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {

            String nome = request.getParameter("nomeparking");
            System.out.println("Nome:" + nome);
            String indirizzo = request.getParameter("indirizzo");
            System.out.println("Ind:" + indirizzo);
            String tariffaAF = request.getParameter("tariffaAF");
            System.out.println("tA:" + tariffaAF);
            String tariffaM = request.getParameter("tariffaM");
            System.out.println("TM:" + tariffaM);
            String postiAuto = request.getParameter("postiAuto");
            System.out.println("PA:" + postiAuto);
            String postiFurgone = request.getParameter("postiFurgone");
            System.out.println("PF:" + postiFurgone);
            String postiMoto = request.getParameter("postiMoto");
            System.out.println("PM:" + postiMoto);

            ModifyDao.modifyIndirizzo(nome, indirizzo);
            ModifyDao.modifyTariffaAF(nome, Double.parseDouble(tariffaAF));
            ModifyDao.modifyTariffaM(nome, Double.parseDouble(tariffaM));
            ModifyDao.modifyPostiAuto(nome, Integer.parseInt(postiAuto));
            ModifyDao.modifyPostiFurgone(nome, Integer.parseInt(postiFurgone));
            ModifyDao.modifyPostiMoto(nome, Integer.parseInt(postiMoto));

            request.getRequestDispatcher("confermaModificaP.jsp").forward(request, response);
        }

    }
}