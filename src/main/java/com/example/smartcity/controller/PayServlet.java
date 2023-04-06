package com.example.smartcity.controller;

import com.example.smartcity.model.BookingBean;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.ParkingDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        System.out.println("Sono nella servlet");


        int id = Integer.parseInt(request.getParameter("idP"));
        ParkingBean parkingBean = ParkingDao.getIstanza().getParkingBean(id);


        BookingBean bookingBean = (BookingBean) request.getAttribute("bookingBean");
        System.out.println("Prenotazione: " + bookingBean.getID_prenotazione());

        request.getRequestDispatcher("thankYouPage.jsp").forward(request,response);

    }
}
