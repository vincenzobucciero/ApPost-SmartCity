package com.example.smartcity.controller;

import com.example.smartcity.dao.ParkingDao;
import com.example.smartcity.model.ParkingBean;
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

        String idparking = request.getParameter("idparking");
        ParkingBean parkingBean = ParkingDao.getIstanza().getParkingBean(Integer.parseInt(idparking));
        parkingBean.setIdParcheggio(Integer.parseInt(idparking));

        request.setAttribute("parkingBean", parkingBean);
        request.getRequestDispatcher("modify.jsp").forward(request, response);
    }

}

