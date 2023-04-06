package com.example.smartcity.controller;


import com.example.smartcity.service.ModifyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));

        String nome = request.getParameter("nome");
        String indirizzo = request.getParameter("indirizzo");
        String tariffaAF = request.getParameter("tariffaAF");
        String tariffaM = request.getParameter("tariffaM");
        String postiAuto = request.getParameter("postiAuto");
        String postiFurgone = request.getParameter("postiFurgone");
        String postiMoto = request.getParameter("postiMoto");

        ModifyService.modifyNome(id, nome);
        ModifyService.modifyIndirizzo(id, indirizzo);
        ModifyService.modifyTariffaAF(id, Double.parseDouble(tariffaAF));
        ModifyService.modifyTariffaM(id, Double.parseDouble(tariffaM));
        ModifyService.modifyPostiAuto(id, Integer.parseInt(postiAuto));
        ModifyService.modifyPostiFurgone(id, Integer.parseInt(postiFurgone));
        ModifyService.modifyPostiMoto(id, Integer.parseInt(postiMoto));

        request.getRequestDispatcher("modify.jsp").forward(request, response);



    }

}
