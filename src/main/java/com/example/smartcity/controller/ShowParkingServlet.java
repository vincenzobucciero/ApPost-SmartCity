package com.example.smartcity.controller;
import com.example.smartcity.model.Bean.BookingBean;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.UserDao;
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


        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            String email = request.getParameter("email");
            List<BookingBean> list = BookingDao.getBooking( email );
            List<BookingBean> list1 = BookingDao.getListBooking();

            session.setAttribute( "email", email);
            session.setAttribute("list", list);
            session.setAttribute("list", list1);
            request.getRequestDispatcher("showBooking.jsp").forward(request, response);

        }

    }
}