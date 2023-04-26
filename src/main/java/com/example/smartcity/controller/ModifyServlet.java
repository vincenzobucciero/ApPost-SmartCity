package com.example.smartcity.controller;

import com.example.smartcity.model.DAO.ModifyDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {

            String nome = request.getParameter("nomeparking");
            String indirizzo = request.getParameter("indirizzo");
            String tariffaAF = request.getParameter("tariffaAF");
            String tariffaM = request.getParameter("tariffaM");
            String postiAuto = request.getParameter("postiAuto");
            String postiFurgone = request.getParameter("postiFurgone");
            String postiMoto = request.getParameter("postiMoto");

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