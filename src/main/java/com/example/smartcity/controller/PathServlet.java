package com.example.smartcity.controller;
import com.example.smartcity.Algoritmo.AStar;
import com.example.smartcity.Algoritmo.Location;
import com.example.smartcity.Algoritmo.Nodo;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.Bean.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Questa servlet riceve una richiesta POST contenente gli indirizzi di partenza e di destinazione.
 * Utilizza l'algoritmo di ricerca A* per trovare il percorso più breve tra i due punti e individuare i parcheggi
 * disponibili lungo il percorso. Successivamente, crea una lista di oggetti ParkingBean contenente
 * i parcheggi disponibili e li passa alla pagina prenotaParcheggio.jsp .
 */

@WebServlet(name = "PathServlet", value = "/PathServlet")
public class PathServlet extends HttpServlet {

    /**
     * Gestisce una richiesta GET
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un'eccezione di servlet
     * @throws IOException se si verifica un'eccezione d'I/O
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Gestisce una richiesta POST, individua i parcheggi disponibili e li passa alla pagina prenotaParcheggio.jsp.
     * Prima di qualsiasi operazione viene verificato se l'utente ha una sessione aperta.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un'eccezione di servlet
     * @throws IOException se si verifica un'eccezione d'I/O
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String startIndirizzo = request.getParameter("start");
        String endIndirizzo = request.getParameter("dest");
        System.out.println("Indirizzi: " + startIndirizzo +" "+ endIndirizzo);

        HttpSession session = request.getSession(false);
        if (session == null) {
            session.setAttribute("isLog", 0);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            UserBean userBean = (UserBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean", userBean);

            Location start = new Location();

            Nodo initialNode = start.chooseStart( startIndirizzo );
            Nodo finalNode = start.chooseEnd( endIndirizzo );
            int rows = 7;
            int cols = 8;

            AStar aStar = new AStar(rows, cols, initialNode, finalNode);
            int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};

            aStar.setBlocchi( blocksArray );
            aStar.setParking( start.setParking() );


            List<ParkingBean> parcheggioDisp = new ArrayList<>();
            List<Nodo> path = aStar.ricercaPercorso();
            for (Nodo node : path) {
                System.out.println(node);
                if (node.isPark() && start.getNodoParkIndirizzo(node) != null) {
                    parcheggioDisp.add(start.getNodoParkIndirizzo(node));
                }
            }

            // Inverti l'ordine della lista parcheggioDisponibili per restituirli in ordine di vicinazna alla destinazione
            Collections.reverse(parcheggioDisp);

            request.setAttribute("start", startIndirizzo);
            request.setAttribute("dest", endIndirizzo);
            request.setAttribute("parcheggioDisp", parcheggioDisp);
            request.getRequestDispatcher("scegliParcheggio.jsp").forward(request, response);

        }
    }

}