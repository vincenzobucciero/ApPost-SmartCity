package com.example.smartcity.controller;

import com.example.smartcity.service.LogService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.example.smartcity.model.BookingBean;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.BookingService;
import com.example.smartcity.service.ParkingService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

@WebServlet(name = "DeleteBookingServlet", value = "/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession( false );
        if ( session == null ) {
            session.setAttribute( "isLog",0 );
            request.getRequestDispatcher( "login.jsp" ).forward(request,response);
        } else {

            String idPrenotazione = request.getParameter( "id" );
            System.out.println( "Cancella: " + idPrenotazione );


            BookingService.deleteBooking( idPrenotazione );


            String email = request.getParameter("email");
            UsersBean usersBean = LogService.getUserBean(email);
            request.setAttribute("email", usersBean.getEmail()); // Passiamo l'email visualizzare le prenotazioni
            request.getRequestDispatcher( "cancelPage.jsp" ).forward(request, response);

        }

    }
}