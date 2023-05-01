package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.UserDao;
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

        UserBean userBean = new UserBean();
        userBean.setNome(name);
        userBean.setCognome(surname);
        userBean.setEmail(email);
        userBean.setPassword(password);

        if ( UserDao.addRegistrazione(userBean) ){
            HttpSession vecchiaSession = request.getSession();

            if (vecchiaSession != null){
                vecchiaSession.invalidate();
            }
            HttpSession newSession = request.getSession();
            newSession.setMaxInactiveInterval(20*60);

            newSession.setAttribute("userBean", userBean);
            newSession.setAttribute("isLog",1);     //1 = sono un utente normale
            request.setAttribute("loggato",1);
            request.setAttribute("userBean", userBean);
            request.getRequestDispatcher("userHomePage.jsp").forward(request, response);

        }
        else {
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
    }
}