package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Questa classe rappresenta una servlet che viene utilizzata per visualizzare
 * la lista dei parcheggi disponibili.
 */

@WebServlet(name = "ShowParkingServlet", value = "/ShowParkingServlet")
public class ShowParkingServlet extends HttpServlet {

    /**
     * Questo metodo gestisce le richieste HTTP di tipo GET.
     *
     * @param request HttpServletRequest contenente i parametri della richiesta HTTP.
     * @param response HttpServletResponse utilizzata per inviare la risposta HTTP.
     * @throws ServletException se si verifica un errore durante l'esecuzione della servlet.
     * @throws IOException se si verifica un errore d'I/O durante l'esecuzione della servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Questo metodo gestisce le richieste HTTP di tipo POST.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request HttpServletRequest contenente i parametri della richiesta HTTP.
     * @param response HttpServletResponse utilizzata per inviare la risposta HTTP.
     * @throws ServletException se si verifica un errore durante l'esecuzione della servlet.
     * @throws IOException se si verifica un errore d'I/O durante l'esecuzione della servlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            List<ParkingBean> parkingBeanList = ParkingDao.getListParking();
            request.setAttribute("list", parkingBeanList);
            request.getRequestDispatcher("listaParking.jsp").forward(request, response);

        }
    }
}