package com.example.smartcity.controller;
<<<<<<< HEAD

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
=======
import com.example.smartcity.model.Bean.BookingBean;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.UserDao;
>>>>>>> origin/master
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

<<<<<<< HEAD
@WebServlet(name = "ShowParkingServlet", value = "/ShowParkingServlet")
public class ShowParkingServlet extends HttpServlet {
=======
@WebServlet(name = "ShowBookingServlet", value = "/ShowBookingServlet")
public class ShowBookingServlet extends HttpServlet {
>>>>>>> origin/master
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

<<<<<<< HEAD
=======

>>>>>>> origin/master
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

<<<<<<< HEAD
            List<ParkingBean> parkingBeanList = ParkingDao.getListParking();
            request.setAttribute("list", parkingBeanList);
            request.getRequestDispatcher("listaParking.jsp").forward(request, response);

        }
=======
            String email = request.getParameter("email");
            List<BookingBean> list = BookingDao.getBooking( email );
            List<BookingBean> list1 = BookingDao.getListBooking();

            session.setAttribute( "email", email);
            session.setAttribute("list", list);
            session.setAttribute("list", list1);
            request.getRequestDispatcher("showBooking.jsp").forward(request, response);

        }

>>>>>>> origin/master
    }
}