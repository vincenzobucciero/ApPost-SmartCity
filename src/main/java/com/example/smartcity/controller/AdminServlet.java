package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * La classe AdminServlet è una servlet che gestisce la pagina di amministrazione del sito SmartCity.
 * Viene utilizzata per aggiornare la lista dei parcheggi nel sistema.
 */

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    /**
     * Questo metodo viene chiamato quando le informazioni personali
     * dell'utente vengono aggiornate tramite una richiesta GET.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException se la richiesta non può essere gestita
     * @throws IOException se viene rilevato un errore di input o output quando la servlet gestisce la richiesta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Metodo POST per l'aggiornamento della lista dei parcheggi
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException se si verifica una eccezione di servlet
     * @throws IOException se si verifica un'eccezione d'ingresso/uscita
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {

            /*Ripassiamo la lista dei parcheggi cosi che quando viene effettuata una
              modifica avremmo la lista aggiornata istantaneamente */

            List<ParkingBean> list = ParkingDao.getListParking();
            session.setAttribute("list", list);

            request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
        }

    }
}