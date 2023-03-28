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
        request.getRequestDispatcher("registrazione.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersBean usersBean = new UsersBean();
        usersBean.setNome(name);
        usersBean.setCognome(surname);
        usersBean.setEmail(email);
        usersBean.setPassword(password);

        /*if (LoginDao.getIstanza().addRegistrazione(name, surname, email, password)){
            System.out.println("Successo");
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }*/


        if (LogService.registration(usersBean)){
            HttpSession vecchiaSession = request.getSession();

            if (vecchiaSession != null){
                vecchiaSession.invalidate();
            }
            HttpSession newSession = request.getSession();
            newSession.setMaxInactiveInterval(20*60);

            newSession.setAttribute("usersBean",usersBean);
            newSession.setAttribute("isLog",1);     //1 = sono un utente normale
            request.setAttribute("loggato",1);
            request.setAttribute("usersBean", usersBean);
            request.getRequestDispatcher("userHomePage.jsp").forward(request, response);

        }
        else {
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
    }
}
