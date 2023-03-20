package com.example.smartcity.controller;

import com.example.smartcity.model.DB;
import com.example.smartcity.model.AccessoLogin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //LoginDao loginDao = new LoginDao();
        //AccessoLogin accessoLogIn = loginDao.logIn(username, password);

        AccessoLogin accessoLogIn = DB.getIstanza().logIn(email, password);
        switch (accessoLogIn) {
            case UTENTE_INESISTENTE:
                request.setAttribute("stato", "UTENTE_INESISTENTE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case PASSWORD_ERRATA:
                request.setAttribute("stato", "PASSWORD_ERRATA");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case SUCCESSO:
                request.setAttribute("stato", "SUCCESSO");
                request.setAttribute("users", email);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                response.sendRedirect(getServletContext().getContextPath());
                break;
            default:
                request.setAttribute("stato", "ERRORE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}