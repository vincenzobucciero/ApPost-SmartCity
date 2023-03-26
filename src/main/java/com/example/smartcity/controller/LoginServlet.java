package com.example.smartcity.controller;

import com.example.smartcity.dao.LoginDao;
import com.example.smartcity.model.AccessoLogin;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.LogService;
import com.example.smartcity.service.ParkingService;
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

        //LoginDao loginDao = new LoginDao();
        //AccessoLogin accessoLogIn = loginDao.logIn(username, password);

        //AccessoLogin accessoLogIn = LoginDao.getIstanza().logIn();
        //LoginDao loginDAO = LoginDao.getIstanza().getUserBean(email);
        UsersBean usersBean = LoginDao.getIstanza().getUserBean(email);

        AccessoLogin accessoLogIn = LogService.logHandler(email, password);

        switch (accessoLogIn) {
            case UTENTE_INESISTENTE:
                request.setAttribute("erroreEmail", "L'email inserita non esiste, riprova");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case PASSWORD_ERRATA:
                request.setAttribute("errorePassword", "La password inserita non è corretta");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case SUCCESSO_ADMIN:
                HttpSession vecchiaSessionAd = request.getSession();

                if (vecchiaSessionAd != null) {
                    vecchiaSessionAd.invalidate();
                }

                HttpSession newSessionAd = request.getSession();
                newSessionAd.setMaxInactiveInterval(20*60);

                newSessionAd.setAttribute("usersBean", usersBean);
                newSessionAd.setAttribute("isLog", 2);
                request.setAttribute("loggato", 2);

                request.setAttribute("stato", "SUCCESSO_ADMIN");
                //request.setAttribute("usersBean", usersBean);
                List<ParkingBean> list = ParkingService.getAllParkings();
                request.setAttribute("list", list);
                request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
                break;
            case SUCCESSO:
                HttpSession vecchiaSession = request.getSession();

                if (vecchiaSession != null) {
                    vecchiaSession.invalidate();
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
                request.setAttribute("stato", "Email o password inseriti non sono corretti");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}