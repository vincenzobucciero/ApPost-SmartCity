package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.CommandPrezzo.Invoker;
import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;
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

        String email = request.getParameter("email");
        String nomeParcheggio = request.getParameter("nomeP");


        HttpSession session = request.getSession(false);
        if (session == null) {
            session.setAttribute("isLog", 0);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

            request.setAttribute("email", email);
            request.setAttribute("nomeP", nomeParcheggio);
            request.getRequestDispatcher("prenotazione.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeParcheggio = request.getParameter("nomeP");
        ParkingBean parkingBean = ParkingDao.getParkingBean(nomeParcheggio);
        String email = request.getParameter("email");
        String dataPrenotazione = request.getParameter("dataP");
        String orarioInizio = request.getParameter("oraI");
        String orarioFine = request.getParameter("oraF");
        String targaVeicolo = request.getParameter("targa");
        String tipoVeicolo = request.getParameter("tipoV");
        String metodoP = request.getParameter("sceltaP");

        String idBooking = RandomStringUtils.randomAlphabetic(7);

        HttpSession session = request.getSession(false);

        if (session == null) {
            session.setAttribute("isLog", 0);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

            BookingBean bookingBean = new BookingBean();
            bookingBean.setID_prenotazione(idBooking);
            bookingBean.setData_prenotazione(dataPrenotazione);
            bookingBean.setOrario_inizio(orarioInizio);
            bookingBean.setOrario_fine(orarioFine);
            bookingBean.setTargaVeicolo(targaVeicolo);
            bookingBean.setTipoVeicolo(VeicoliEnum.valueOf(tipoVeicolo));
            bookingBean.setEmail(email);
            bookingBean.setPagamento(metodoP);
            bookingBean.setNomeParcheggio(nomeParcheggio);


            Invoker invoker = new Invoker();

            switch (metodoP){
                case "Carta di Credito/PayPal":
                    if(invoker.getPosti(bookingBean.getTipoVeicolo(), parkingBean, bookingBean) > 0)
                    {
                        double price = invoker.getTot(bookingBean.getTipoVeicolo(), parkingBean, bookingBean);
                        bookingBean.setPrezzo(price);

                        session.setAttribute("bookingBean", bookingBean);
                        request.getRequestDispatcher("pagamento.jsp").forward(request, response);
                    }
                    else
                        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                    break;
                case "Al parcheggio":
                    if(invoker.getPosti(bookingBean.getTipoVeicolo(), parkingBean, bookingBean) > 0)
                    {
                        double price = invoker.getTot(bookingBean.getTipoVeicolo(), parkingBean, bookingBean);
                        bookingBean.setPrezzo(price);
                        BookingDao.addBooking(bookingBean);

                        session.setAttribute("bookingBean", bookingBean);
                        session.setAttribute("email", bookingBean.getEmail());
                        request.getRequestDispatcher("thankYouPage.jsp").forward(request, response);
                    }
                    else
                        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                    break;
                default:
                    break;
            }


        }

    }
}