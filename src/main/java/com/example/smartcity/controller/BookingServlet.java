package com.example.smartcity.controller;


import com.example.smartcity.model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

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
            request.setAttribute("parkingBean", parkingBean); //serve??
            request.setAttribute("id", id);
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
        String metodoP = request.getParameter("sceltaP");

        String idBooking = RandomStringUtils.randomAlphabetic(7);


        HttpSession session = request.getSession(false);

        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

            BookingBean bookingBean = new BookingBean();
            bookingBean.setID_prenotazione(idBooking);
            bookingBean.setData_prenotazione( dataPrenotazione );
            bookingBean.setOrario_inizio( orarioInizio );
            bookingBean.setOrario_fine( orarioFine );
            bookingBean.setTargaVeicolo( targaVeicolo );
            bookingBean.setTipoVeicolo( tipoVeicolo );
            bookingBean.setEmail( email );
            bookingBean.setPagamento( metodoP );

            switch (tipoVeicolo){
                case "Auto":
                case "Furgone":
                    bookingBean.setPrezzo(parkingBean.getTariffaAF());
                    break;
                case "Moto":
                    bookingBean.setPrezzo(parkingBean.getTariffaM());
                    break;
                default:
                    break;
            }


            System.out.println("pagamento: " + metodoP);
            switch (metodoP){
                case "Carta di Credito/PayPal":
                    session.setAttribute("bookingBean", bookingBean);
                    session.setAttribute("email", email);
                    request.setAttribute("id", id);
                    request.getRequestDispatcher("pagamento.jsp").forward(request, response);
                    break;
                case "Al parcheggio":
                    session.setAttribute("bookingBean", bookingBean);
                    //request.setAttribute("id", id);
                    request.getRequestDispatcher("thankYouPage.jsp").forward(request, response);
                    break;
                default:
                    break;
            }


        }

    }
}