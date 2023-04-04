package com.example.smartcity.controller;


import com.example.smartcity.model.BookingBean;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.BookingService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        System.out.println(email);

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean", usersBean);
            request.setAttribute( "email", usersBean.getEmail() );
            request.getRequestDispatcher("prenotazione.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String dataPrenotazione = request.getParameter("dataP");
        String orarioInizio = request.getParameter("oraI");
        String orarioFine = request.getParameter("oraF");
        String targaVeicolo = request.getParameter("targa");
        String tipoVeicolo = request.getParameter("tipoV");

        System.out.println("Data: "+ dataPrenotazione);
        System.out.println(orarioInizio + orarioFine);

        BookingBean bookingBean = new BookingBean();
        bookingBean.setData_prenotazione( dataPrenotazione );
        bookingBean.setOrario_inizio( orarioInizio );
        bookingBean.setOrario_fine( orarioFine );
        bookingBean.setTargaVeicolo( targaVeicolo );
        bookingBean.setTipoVeicolo( tipoVeicolo );
        bookingBean.setEmail( email );

        BookingService.Booking(bookingBean);

        UsersBean usersBean = (UsersBean) request.getSession().getAttribute("usersBean");
        request.setAttribute("usersBean", usersBean);
        request.setAttribute( "email", usersBean.getEmail() );
        request.getRequestDispatcher("prenotazione.jsp").forward(request, response);
        request.getRequestDispatcher("prenotazione.jsp").forward(request, response);

    }
}