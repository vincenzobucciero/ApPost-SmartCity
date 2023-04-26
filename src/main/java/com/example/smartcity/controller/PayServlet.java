package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;

import com.example.smartcity.service.Strategy.*;
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

        String email = request.getParameter("email");
        String nome = request.getParameter("intestatario");
        String numeroCarta = request.getParameter("numCarta");
        String cvv = request.getParameter("cvv");
        String meseScadenza = request.getParameter("MM");
        String annoScadenza = request.getParameter("YY");

        String dataScadenza = annoScadenza + "-" + meseScadenza;

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else {
            BookingBean bookingBean = ( BookingBean ) session.getAttribute("bookingBean");
            String nomeParcheggio = bookingBean.getNomeParcheggio();
            ParkingBean parkingBean = ParkingDao.getParkingBean(nomeParcheggio);

            PaymentStrategy paymentMethod = new CreditCardStrategy( nome, numeroCarta, cvv,dataScadenza );

            if(paymentMethod.pay(bookingBean.getPrezzo())) {
                session.setAttribute("email", bookingBean.getEmail());
                session.setAttribute("bookingBean", bookingBean);
                BookingDao.addBooking(bookingBean);
                request.getRequestDispatcher("thankYouPage.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("errorPage.jsp").forward(request,response);
            }

        }

    }
}