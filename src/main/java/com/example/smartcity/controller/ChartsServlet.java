package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChartsServlet", value = "/ChartsServlet")
<<<<<<< HEAD
public class ChartsServlet extends HttpServlet  {
=======
public class ChartsServlet extends HttpServlet {
>>>>>>> origin/master
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            List<ParkingBean> list = ParkingDao.getListParking();
            request.setAttribute("list",list);

            String veicolo = request.getParameter("tipoV");
            String parcheggio = request.getParameter("parcheggio");
            String mese = request.getParameter("mese");
            Month nomeMese = Month.valueOf(mese.toUpperCase());
            int numeroMese = nomeMese.getValue();


            System.out.println("Veicolo " + veicolo);
            System.out.println("\nParcheggio " + parcheggio);
            System.out.println("\nMese " + mese + " - " +numeroMese);

            List<Double> statistiche = new ArrayList<>();
            for( int i = 1; i < 6; i++ ) {
                double st = ParkingDao.getStatisticheAccessi(parcheggio, VeicoliEnum.valueOf(veicolo), numeroMese, i);
                statistiche.add( st );
            }
            request.setAttribute( "statistiche", statistiche );
            request.getRequestDispatcher("statistiche.jsp").forward(request,response);
        }
    }
}