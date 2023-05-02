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

/**
 * Questa servlet gestisce la prenotazione di un parcheggio da parte di un utente registrato.
 * Gli utenti possono accedere alla pagina di prenotazione tramite la pagina dei parcheggi disponibili,
 * dove inseriscono la data, l'ora d'inizio e di fine della prenotazione, la targa del veicolo e il metodo di pagamento.
 * La servlet utilizza il pattern Command per calcolare il prezzo in base al tipo di veicolo,
 * al parcheggio e alla durata della prenotazione, e offre due opzioni di pagamento:
 * carta di credito/PayPal o pagamento al parcheggio.
 */

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {

    /**
     * Metodo che gestisce la richiesta GET della servlet, che viene utilizzata per
     * visualizzare la pagina di prenotazione.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP del client
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP del server
     * @throws ServletException se si verifica un'eccezione durante l'esecuzione della servlet
     * @throws IOException se si verifica un'eccezione d'ingresso/uscita durante l'esecuzione della servlet
     */
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


/**
 * Questo metodo viene chiamato quando viene effettuata una richiesta HTTP POST al servlet.
 * In base ai parametri della richiesta, crea una nuova prenotazione di parcheggio
 * e la salva nel database o la mostra all'utente per il pagamento.
 * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
 *
 * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP del client
 * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP del server
 * @throws ServletException se si verifica un'eccezione durante l'esecuzione della servlet
 * @throws IOException se si verifica un'eccezione d'ingresso/uscita durante l'esecuzione della servlet
 */
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