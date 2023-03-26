package com.example.smartcity.controller;


import com.example.smartcity.dao.ParkingDao;
import com.example.smartcity.model.ParkingBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        /*


        String idparking = request.getParameter("idparking");
        String nomeParcheggio = request.getParameter("nomeParcheggio");
        String indirizzo = request.getParameter("indirizzo");
        String tariffa = request.getParameter("tariffa");
        String numPosti = request.getParameter("numPosti");



        ModifyService.modifyNome(Integer.parseInt(request.getParameter(idparking)), nomeParcheggio);



        ModifyService.modifyIndirizzo(Integer.parseInt(idparking), indirizzo);
        ModifyService.modifyTariffa(Integer.parseInt(idparking), Double.parseDouble(tariffa));
        ModifyService.modifyNumPosti(Integer.parseInt(idparking), Integer.parseInt(numPosti));

        ParkingBean parkingBean = ParkingDao.getIstanza().getparcheggioBean(Integer.parseInt(idparking));
        request.getRequestDispatcher("modificaTariffa.jsp").forward(request, response);
        request.setAttribute("parkingBean", parkingBean);

    }

         */


        String idparking = request.getParameter("idparking");
        ParkingBean parkingBean = ParkingDao.getIstanza().getparcheggioBean(Integer.parseInt(idparking));

        HttpSession vecchiaSession = request.getSession();
        if (vecchiaSession != null){
            vecchiaSession.invalidate();
        }
        HttpSession newSession = request.getSession();
        newSession.setMaxInactiveInterval(20*60);

        newSession.setAttribute("parcheggioBean", parkingBean);
        newSession.setAttribute("isLog",2);
        request.setAttribute("loggato",2);
        request.setAttribute("parcheggioBean", parkingBean);
        request.getRequestDispatcher("modificaTariffa.jsp").forward(request, response);
    }
}
