package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InfoParkingServlet", value = "/InfoParkingServlet")
public class InfoParkingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward( request,response );
        }
        else {

            String nomeParcheggio = request.getParameter("nomeparking");
            ParkingBean parkingBean = ParkingDao.getParkingBean( nomeParcheggio );
            parkingBean.setNomeParcheggio( nomeParcheggio );

            request.setAttribute( "parkingBean", parkingBean );
            request.getRequestDispatcher( "modify.jsp" ).forward(request, response);

        }
    }


}