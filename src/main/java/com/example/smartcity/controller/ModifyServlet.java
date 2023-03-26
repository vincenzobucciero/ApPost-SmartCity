package com.example.smartcity.controller;


import com.example.smartcity.dao.ParcheggioDAO;
import com.example.smartcity.model.ParcheggioBean;
import com.example.smartcity.service.ModifyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

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

        ParcheggioBean parcheggioBean = ParcheggioDAO.getIstanza().getparcheggioBean(Integer.parseInt(idparking));
        request.getRequestDispatcher("modificaTariffa.jsp").forward(request, response);
        request.setAttribute("parkingBean", parcheggioBean);

    }

         */


        String idparking = request.getParameter("idparking");
        ParcheggioBean parcheggioBean = ParcheggioDAO.getIstanza().getparcheggioBean(Integer.parseInt(idparking));

        HttpSession vecchiaSession = request.getSession();
        if (vecchiaSession != null){
            vecchiaSession.invalidate();
        }
        HttpSession newSession = request.getSession();
        newSession.setMaxInactiveInterval(20*60);

        newSession.setAttribute("parcheggioBean",parcheggioBean);
        newSession.setAttribute("isLog",2);
        request.setAttribute("loggato",2);
        request.setAttribute("parcheggioBean", parcheggioBean);
        request.getRequestDispatcher("modificaTariffa.jsp").forward(request, response);
    }
}
