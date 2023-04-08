package com.example.smartcity.controller;
import com.example.smartcity.model.BookingBean;
import com.example.smartcity.model.BookingDao;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.ParkingDao;

import jakarta.servlet.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowBookingServlet", value = "/ShowBookingServlet")
public class ShowBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        System.out.println("email " + email);

        List<BookingBean> bookingBeans = BookingDao.getIstanza().getBooking(email); //ritorna l'email della prenotazione
        int size = bookingBeans.size();
        request.setAttribute("list", bookingBeans);
        request.setAttribute("size",size);
        request.getRequestDispatcher("showBooking.jsp").forward(request, response);
    }
}