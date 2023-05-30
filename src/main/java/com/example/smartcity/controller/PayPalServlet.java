package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.Command.VeicoliEnum;
import com.example.smartcity.service.Strategy.PaypalStrategy;
import com.example.smartcity.service.Strategy.PaymentStrategy;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * La classe PayPalServlet gestisce le richieste per effettuare un pagamento tramite PayPal.
 * Riceve come parametro l'email e la password del proprio account PayPal, e utilizza una
 * strategia di pagamento di tipo PaypalStrategy per effettuare il pagamento. Se il pagamento
 * va a buon fine, viene aggiunto il prenotazione al database e viene visualizzata una pagina
 * di ringraziamento, altrimenti viene mostrata una pagina di errore.
 */
@WebServlet(name = "PayPalServlet", value = "/PayPalServlet")
public class PayPalServlet extends HttpServlet {

    /**
     * Gestisce una richiesta GET
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException Eccezione lanciata in caso di errore durante l'esecuzione della servlet
     * @throws IOException Eccezione lanciata in caso di errore di I/O
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    /**
     * Metodo che gestisce la richiesta POST per effettuare il pagamento tramite PayPal.
     * Riceve l'email e la password dell'account PayPal, verifica se l'utente è loggato,
     * recupera la prenotazione e il parcheggio relativi, definisce il tipo di veicolo
     * e la strategia di pagamento, e se il pagamento va a buon fine aggiunge la prenotazione
     * al database e mostra una pagina di ringraziamento, altrimenti mostra una pagina di errore.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException Eccezione lanciata in caso di errore durante l'esecuzione della servlet
     * @throws IOException Eccezione lanciata in caso di errore d'I/O
     */
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