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
        String tariffa = request.getParameter("tariffa");
        String numPosti = request.getParameter("numPosti");

        ModifyService.modifyNome(id, nome);
        ModifyService.modifyIndirizzo(id, indirizzo);
        ModifyService.modifyTariffa(id, Double.parseDouble(tariffa));
        ModifyService.modifyNumPosti(id, Integer.parseInt(numPosti));
        request.getRequestDispatcher("modify.jsp").forward(request, response);

    }

}
