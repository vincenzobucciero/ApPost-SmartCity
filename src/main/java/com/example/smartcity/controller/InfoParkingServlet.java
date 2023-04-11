package com.example.smartcity.controller;

import com.example.smartcity.model.ParkingDao;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.UsersBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InfoParkingServlet", value = "/InfoParkingServlet")
public class InfoParkingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        request.getRequestDispatcher("adminHomePage.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        /*

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean",usersBean);
            //request.getRequestDispatcher("adminHomepage.jsp").forward(request,response);
        }

        */

        String idparking = request.getParameter("idparking");
        ParkingBean parkingBean = ParkingDao.getIstanza().getParkingBean(Integer.parseInt(idparking));
        parkingBean.setIdParcheggio(Integer.parseInt(idparking));

        request.setAttribute("parkingBean", parkingBean);
        request.getRequestDispatcher("modify.jsp").forward(request, response);
    }

}

