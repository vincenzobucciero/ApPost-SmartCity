package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;
import com.example.smartcity.service.Strategy.PaypalStrategy;
import com.example.smartcity.service.Strategy.PaymentStrategy;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PayPalServlet", value = "/PayPalServlet")
public class PayPalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");



        String emailPP = request.getParameter("emailPP");
        String passwordPP = request.getParameter("passwordPP");

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            BookingBean bookingBean = (BookingBean) session.getAttribute("bookingBean");
            String nomeParcheggio = bookingBean.getNomeParcheggio();
            ParkingBean parkingBean = ParkingDao.getParkingBean(nomeParcheggio);

            VeicoliEnum tipoVeicolo = bookingBean.getTipoVeicolo();
            System.out.println("veicolo " + tipoVeicolo);

            PaymentStrategy paymentMethod = new PaypalStrategy(emailPP, passwordPP);

            if(paymentMethod.pay(bookingBean.getPrezzo())) {
                BookingDao.addBooking(bookingBean);
                session.setAttribute("email", bookingBean.getEmail());
                request.getRequestDispatcher("thankYouPage.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("errorPage.jsp").forward(request,response);
            }


        }

    }
}