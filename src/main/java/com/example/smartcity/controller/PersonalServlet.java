package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PersonalServlet", value = "/PersonalServlet")
public class PersonalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UserBean userBean = (UserBean) session.getAttribute("userBean");
            request.setAttribute("userBean", userBean);
            System.out.println("Personal Servlet: " + userBean.getNome());
            request.getRequestDispatcher("infoUtente.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}