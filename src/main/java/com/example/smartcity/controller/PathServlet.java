package com.example.smartcity.controller;

import com.example.smartcity.service.Algoritmo.AStar;
import com.example.smartcity.service.Algoritmo.Location;
import com.example.smartcity.service.Algoritmo.Nodo;
import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.UsersBean;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
     * @throws IOException se si verifica un'eccezione di I/O
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Gestisce una richiesta POST, individua i parcheggi disponibili e li passa alla pagina prenotaParcheggio.jsp.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta HTTP
     * @param response l'oggetto HttpServletResponse che contiene la risposta HTTP
     * @throws ServletException se si verifica un'eccezione di servlet
     * @throws IOException se si verifica un'eccezione di I/O
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String startIndirizzo = request.getParameter("start");
        String endIndirizzo = request.getParameter("dest");

        System.out.println("Indirizzi: "+ startIndirizzo + endIndirizzo);

        HttpSession session = request.getSession(false);

        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean", usersBean);

            Location start = new Location();

            Nodo initialNode = start.chooseStart(startIndirizzo);
            Nodo finalNode = start.chooseEnd(endIndirizzo);

            int rows = 6;
            int cols = 7;

            AStar aStar = new AStar(rows, cols, initialNode, finalNode);

            int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};

            aStar.setBlocchi(blocksArray);
            aStar.setParking(start.setParking());

            List<Nodo> nodo = start.getNodopark();

            for (Nodo nodoPark : nodo) {
                System.out.println("Parcheggi situati in: " + nodoPark.getIndirizzo());
            }

            List<ParkingBean> parcheggioDisp = new ArrayList<>();
            List<Nodo> path = aStar.ricercaPercorso();

            for (Nodo node : path) {
                System.out.println(node);
                if (node.isPark() && start.getNodoParkIndirizzo(node) != null) {
                    System.out.println("dentro");
                    parcheggioDisp.add(start.getNodoParkIndirizzo(node));
                    System.out.println("parcheggio size " + parcheggioDisp.size());
                }
            }

            request.setAttribute("start", startIndirizzo);
            request.setAttribute("dest", endIndirizzo);

            int size = parcheggioDisp.size();

            request.setAttribute("size", size);

            request.setAttribute("parcheggioDisp", parcheggioDisp);

            request.getRequestDispatcher("prenotaParcheggio.jsp").forward(request,response);

        }

    }

}