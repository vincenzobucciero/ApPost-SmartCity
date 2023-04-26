package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.model.DAO.UserDao;
import com.example.smartcity.service.ChainOfResponsability.AccessoLogin;
import com.example.smartcity.service.ChainOfResponsability.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserBean userBean = UserDao.getUserBean( email );
        AccessoLogin accessoLogIn = UserService.logHandler( email, password );
        List<ParkingBean> list = ParkingDao.getListParking();

        switch ( accessoLogIn ) {
            case UTENTE_INESISTENTE:
                request.setAttribute("stato", "UTENTE_INESISTENTE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case PASSWORD_ERRATA:
                request.setAttribute("stato", "PASSWORD_ERRATA");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case SUCCESSO:
                HttpSession vecchiaSession = request.getSession();

                if (vecchiaSession != null){
                    vecchiaSession.invalidate();
                }
                HttpSession newSession = request.getSession();
                newSession.setMaxInactiveInterval(20*60);

                newSession.setAttribute("userBean", userBean);
                newSession.setAttribute("isLog",1);     //1 = sono un utente normale
                request.setAttribute("loggato",1);
                System.out.println("Login Servlet: " + userBean.getNome());
                request.setAttribute("stato", "SUCCESSO");
                request.setAttribute("email", userBean.getEmail()); // Passiamo l'email visualizzare le prenotazioni
                request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
                break;
            case SUCCESSO_ADMIN:
                HttpSession vecchiaSessionAd = request.getSession();

                if (vecchiaSessionAd != null){
                    vecchiaSessionAd.invalidate();
                }
                HttpSession newSessionAd = request.getSession();
                newSessionAd.setMaxInactiveInterval(20*60);

                newSessionAd.setAttribute("userBean", userBean);
                newSessionAd.setAttribute("isLog",2);       //2 = sono un admin

                request.setAttribute("loggato",2);
                request.setAttribute("stato", "SUCCESSO_ADMIN");
                newSessionAd.setAttribute("list", list);

                request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("stato", "ERRORE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}