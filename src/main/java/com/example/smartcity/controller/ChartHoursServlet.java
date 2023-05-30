package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.service.Command.VeicoliEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe ChartsServlet gestisce le richieste HTTP in arrivo dal client per generare le statistiche sulle ore effettive di parcheggio.
 * La classe estende HttpServlet e implementa due metodi, doGet() e doPost(), i quali sono responsabili
 * di gestire le richieste HTTP GET e POST rispettivamente.
 */

@WebServlet(name = "ChartHoursServlet", value = "/ChartHoursServlet")
public class ChartHoursServlet extends HttpServlet {

    /**
     * Gestisce le richieste HTTP GET in arrivo dal client.
     * Questo metodo non esegue alcuna operazione e semplicemente restituisce una pagina vuota.
     *
     * @param request La richiesta HTTP in arrivo dal client.
     * @param response La risposta HTTP inviata al client.
     * @throws ServletException se si verifica un errore nella gestione della richiesta.
     * @throws IOException se si verifica un errore nella gestione dell'uscita della risposta.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("statisticheOre.jsp").forward(request,response);
    }


    /**
     * Gestisce le richieste HTTP POST in arrivo dal client.
     * Questo metodo recupera la lista di tutti i parcheggi tramite il metodo getListParking() del DAO ParkingDao.
     * Successivamente, vengono recuperati i parametri della richiesta relativi al tipo di veicolo,
     * al parcheggio e al mese desiderato. Viene effettuato una conversione del mese inserito, nel rispettivo numero
     * tramite l'utilizzo della classe Month e il metodo valueOf().
     * Vengono inoltre creati un ArrayList <Double> e un ciclo for per ottenere le statistiche sulle ore effettive di
     * parcheggio in base ai parametri inseriti nella richiesta. I dati ottenuti vengono salvati nell'ArrayList e
     * inviati alla pagina statistiche.jsp tramite il metodo setAttribute() della request.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request La richiesta HTTP in arrivo dal client.
     * @param response La risposta HTTP inviata al client.
     * @throws ServletException se si verifica un errore nella gestione della richiesta.
     * @throws IOException se si verifica un errore nella gestione dell'uscita della risposta.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {

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
                double st = ParkingDao.getStatisticheOre(parcheggio, VeicoliEnum.valueOf(veicolo), numeroMese, i);
                statistiche.add( st );
            }

            request.setAttribute("veicolo",veicolo);
            request.setAttribute("park",parcheggio);
            request.setAttribute("meseScelto",mese);

            request.setAttribute( "statistiche", statistiche );
            request.getRequestDispatcher("statisticheOre.jsp").forward(request,response);
        }
    }
}