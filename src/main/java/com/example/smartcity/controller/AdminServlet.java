package com.example.smartcity.controller;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ParkingService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {

            //Gli ripasso la lista poichè aggiornata

            List<ParkingBean> list = ParkingService.getAllParkings();
            session.setAttribute("list", list);
            request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
        }

    }
}