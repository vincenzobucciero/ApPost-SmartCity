package com.example.smartcity.controller;

import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.LogService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("registrazione.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersBean usersBean = new UsersBean();
        usersBean.setNome(nome);
        usersBean.setCognome(cognome);
        usersBean.setEmail(email);
        usersBean.setPassword(password);

        /*if (LoginDAO.getIstanza().addRegistrazione(name, surname, email, password)){
            System.out.println("Successo");
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }*/
        if (LogService.registration(usersBean)){
            request.setAttribute("userBean", usersBean);
            request.getRequestDispatcher("profilo_utente.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
    }
}
