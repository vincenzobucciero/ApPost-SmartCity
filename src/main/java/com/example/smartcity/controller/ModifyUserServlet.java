package com.example.smartcity.controller;

import com.example.smartcity.service.ModifyService;
import com.example.smartcity.service.ModifyUserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifyUserServlet", value = "/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String newEmail = request.getParameter("email");
        String password = request.getParameter("password");        //String tariffaM = request.getParameter("tariffaM");
        //String postiAuto = request.getParameter("postiAuto");
        //String postiFurgone = request.getParameter("postiFurgone");
        //String postiMoto = request.getParameter("postiMoto");

        ModifyUserService.modifyNome(email, nome);
        ModifyUserService.modifyCognome(email, cognome);
        ModifyUserService.modifyEmail(email, newEmail);
        ModifyUserService.modifyPassword(email, password);

        request.getRequestDispatcher("modifyUserInfo.jsp").forward(request, response);

    }
}
