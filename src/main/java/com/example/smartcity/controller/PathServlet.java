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
import java.util.List;

@WebServlet(name = "PathServlet", value = "/PathServlet")
public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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

            Nodo initialNode = start.chooseStart(startIndirizzo);
            Nodo finalNode = start.chooseEnd(endIndirizzo);
            int rows = 6;
            int cols = 7;

            AStar aStar = new AStar(rows, cols, initialNode, finalNode);
            int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};

            aStar.setBlocchi(blocksArray);
            aStar.setParking(start.setParking());


            List<ParkingBean> parcheggioDisp = new ArrayList<>();
            List<Nodo> path = aStar.ricercaPercorso();
            for (Nodo node : path) {
                System.out.println(node);
                if (node.isPark() && start.getNodoParkIndirizzo(node) != null) {
                    parcheggioDisp.add(start.getNodoParkIndirizzo(node));
                    System.out.println("parcheggio size " + parcheggioDisp.size());
                }
            }

            request.setAttribute("start", startIndirizzo);
            request.setAttribute("dest", endIndirizzo);

            //Nella jsp basta fare list.size() controlla !!!
            int size = parcheggioDisp.size();
            request.setAttribute("size", size);

            request.setAttribute("parcheggioDisp", parcheggioDisp);
            request.getRequestDispatcher("scegliParcheggio.jsp").forward(request, response);

        }
    }

}