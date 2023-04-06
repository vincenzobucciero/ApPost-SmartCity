package com.example.smartcity.controller;


import com.example.smartcity.model.BookingBean;
import com.example.smartcity.service.Factory.*;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.ParkingDao;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.BookingService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");

        ParkingBean parkingBean = ParkingDao.getIstanza().getParkingBean(id);

        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean", usersBean);
            request.setAttribute( "email", usersBean.getEmail() );
            request.setAttribute("parkingBean", parkingBean);
            request.setAttribute("id", id);
            request.setAttribute("feedback",false);
            request.getRequestDispatcher("prenotazione.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ParkingBean parkingBean = ParkingDao.getIstanza().getParkingBean(id);

        String email = request.getParameter("email");
        String dataPrenotazione = request.getParameter("dataP");
        String orarioInizio = request.getParameter("oraI");
        String orarioFine = request.getParameter("oraF");
        String targaVeicolo = request.getParameter("targa");
        String tipoVeicolo = request.getParameter("tipoV");

        System.out.println(email);
        System.out.println("idParcheggio: " + id);
        System.out.println("parking: " + parkingBean.getNomeParcheggio());
        System.out.println("Data: "+ dataPrenotazione);
        System.out.println("Orari: " + orarioInizio +" "+ orarioFine);

        BookingBean bookingBean = new BookingBean();
        bookingBean.setID_prenotazione( id );
        bookingBean.setData_prenotazione( dataPrenotazione );
        bookingBean.setOrario_inizio( orarioInizio );
        bookingBean.setOrario_fine( orarioFine );
        bookingBean.setTargaVeicolo( targaVeicolo );
        bookingBean.setTipoVeicolo( tipoVeicolo );
        bookingBean.setEmail( email );

        //BookingService.Booking(bookingBean);

        //UsersBean usersBean = (UsersBean) request.getSession().getAttribute("usersBean");
        //request.setAttribute("usersBean", usersBean);
        //request.setAttribute( "email", usersBean.getEmail() );
        //request.setAttribute("parkingBean", parkingBean);
        //request.setAttribute("id", parkingBean.getIdParcheggio());


        System.out.println("veicolo " + tipoVeicolo);
        switch (tipoVeicolo){
            case "auto":
                FactoryPosto factoryAuto = new FactoryPostoAuto();
                Posto auto = factoryAuto.getPosto(id, parkingBean);
                break;
            case "furgone":
                FactoryPosto factoryFurgone = new FactoryPostoFurgone();
                Posto furgone = factoryFurgone.getPosto(id, parkingBean);
                break;
            case "moto":
                FactoryPosto factoryMoto = new FactoryPostoMoto();
                Posto moto = factoryMoto.getPosto(id, parkingBean);
                break;
            default:
                break;
        }

        request.setAttribute("bookingBean",bookingBean);

        request.getRequestDispatcher("prenotazione.jsp").forward(request, response);
    }
}