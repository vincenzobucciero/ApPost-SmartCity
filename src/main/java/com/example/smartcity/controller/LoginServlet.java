package com.example.smartcity.controller;

import com.example.smartcity.dao.LoginDAO;
import com.example.smartcity.model.AccessoLogin;

import com.example.smartcity.model.ParcheggioBean;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.LogService;
import com.example.smartcity.service.ParcheggioService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

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

        //LoginDAO loginDao = new LoginDAO();
        //AccessoLogin accessoLogIn = loginDao.logIn(username, password);

        //AccessoLogin accessoLogIn = LoginDAO.getIstanza().logIn();
        LoginDAO loginDAO = LoginDAO.getIstanza();
        UsersBean usersBean = loginDAO.getUserBean(email);

        AccessoLogin accessoLogIn = LogService.logHandler(usersBean);

        switch (accessoLogIn) {
            case UTENTE_INESISTENTE:
                request.setAttribute("stato", "UTENTE_INESISTENTE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case PASSWORD_ERRATA:
                request.setAttribute("stato", "PASSWORD_ERRATA");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case SUCCESSO_ADMIN:
                HttpSession oldSessionAd = request.getSession();

                if (oldSessionAd != null) {
                    oldSessionAd.invalidate();
                }

                HttpSession newSessionAd = request.getSession();
                newSessionAd.setMaxInactiveInterval(20*60);

                newSessionAd.setAttribute("usersBean", usersBean);
                newSessionAd.setAttribute("isLog", 1);
                request.setAttribute("loggato", 1);
                request.setAttribute("stato", "SUCCESSO_ADMIN");
                request.setAttribute("usersBean", usersBean);
                List<ParcheggioBean> list = ParcheggioService.getAllParkings();
                request.setAttribute("list", list);
                request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
                break;
            case SUCCESSO:
                HttpSession oldSession = request.getSession();

                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = request.getSession();
                newSession.setMaxInactiveInterval(20*60);

                newSession.setAttribute("usersBean", usersBean);
                newSession.setAttribute("isLog", 1);
                request.setAttribute("loggato", 1);
                request.setAttribute("stato", "SUCCESSO");
                request.setAttribute("usersBean", usersBean);
                request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
            default:
                request.setAttribute("stato", "ERRORE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}