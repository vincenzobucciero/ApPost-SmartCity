package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.Factory.*;
import com.example.smartcity.service.Strategy.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * La classe PayServlet è una servlet che gestisce il pagamento della prenotazione di un parcheggio.
 * La servlet riceve i parametri relativi al metodo di pagamento (nome, numero carta, cvv, data di scadenza)
 * e alla prenotazione (nome parcheggio, tipo veicolo, prezzo).
 * In base al tipo di veicolo, viene creata una factory di posti adatta e viene inserita la prenotazione nel database.
 * La servlet ha due metodi principali: doGet e doPost.
 */
@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {

    /**
     * Metodo che gestisce una richiesta GET.
     *
     * @param request la richiesta HTTP
     * @param response la risposta HTTP
     * @throws ServletException se si verifica un errore nella servlet
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Metodo che gestisce una richiesta POST.
     *
     * @param request la richiesta HTTP
     * @param response la risposta HTTP
     * @throws ServletException se si verifica un errore nella servlet
     * @throws IOException se si verifica un errore di input/output
     */
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
        } else {

            BookingBean bookingBean = ( BookingBean ) session.getAttribute("bookingBean");
            String nomeParcheggio = bookingBean.getNomeParcheggio();
            ParkingBean parkingBean = ParkingDao.getParkingBean(nomeParcheggio);

            PaymentStrategy paymentMethod = new CreditCardStrategy( nome, numeroCarta, cvv,dataScadenza );

            String tipoVeicolo = bookingBean.getTipoVeicolo();
            System.out.println( "veicolo " + tipoVeicolo );

            switch ( tipoVeicolo ){

                case "Auto":
                    if(paymentMethod.pay(bookingBean.getPrezzo())) {

                        FactoryPosto factoryAuto = new FactoryPostoAuto();

                        Posto auto = factoryAuto.getPosto( parkingBean );

                        //inserisco la prenotazione
                        BookingDao.addBooking(bookingBean);

                        session.setAttribute( "email", email );
                        session.setAttribute( "bookingBean", bookingBean );

                        request.getRequestDispatcher( "thankYouPage.jsp" ).forward(request,response);
                    }
                    else {
                        request.getRequestDispatcher( "errorPage.jsp" ).forward(request,response);
                    }
                    break;

                case "Furgone":
                    if(paymentMethod.pay(bookingBean.getPrezzo())) {

                        FactoryPosto factoryFurgone = new FactoryPostoFurgone();
                        Posto furgone = factoryFurgone.getPosto( parkingBean );

                        //inserisco la prenotazione
                        BookingDao.addBooking(bookingBean);

                        session.setAttribute( "email", email );
                        session.setAttribute( "bookingBean", bookingBean );

                        request.getRequestDispatcher( "thankYouPage.jsp" ).forward(request,response);
                    }
                    else {
                        request.getRequestDispatcher( "errorPage.jsp" ).forward(request,response);
                    }
                    break;

                case "Moto":
                    if(paymentMethod.pay(bookingBean.getPrezzo())) {

                        FactoryPosto factoryMoto = new FactoryPostoMoto();
                        Posto moto = factoryMoto.getPosto( parkingBean );

                        //inserisco la prenotazione
                        BookingDao.addBooking(bookingBean);

                        session.setAttribute( "email", email );
                        session.setAttribute( "bookingBean", bookingBean );

                        request.getRequestDispatcher( "thankYouPage.jsp" ).forward(request,response);
                    }
                    else {
                        request.getRequestDispatcher( "errorPage.jsp" ).forward(request,response);
                    }
                    break;

                default:
                    request.getRequestDispatcher( "errorPage.jsp" ).forward(request,response);
                    break;
            }

        }

    }
}