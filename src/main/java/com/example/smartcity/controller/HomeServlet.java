
package com.example.smartcity.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * Questa classe rappresenta una servlet per la home page del sito.
 * Viene utilizzata per mostrare la pagina iniziale del sito e gestire la sessione dell'utente.
 */
@WebServlet(name = "HomeServlet", value = "/homepage")
public class HomeServlet extends HttpServlet {

    /**
     * Metodo doGet che gestisce la richiesta GET della home page.
     * Viene utilizzato per verificare se l'utente ha una sessione aperta e passare il valore isLog al file JSP.
     * Infine, viene inoltrata la richiesta al file JSP che visualizzerà la home page.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException Se si verifica un errore nella servlet
     * @throws IOException Se si verifica un errore d'input/output
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession(false);
        int isLog = 0;
        if (session == null){
            session = request.getSession();
            session.setAttribute("isLog",0);
        } else {
            isLog = (int) session.getAttribute("isLog");
        }
        request.setAttribute("loggato",isLog);
        response.setContentType("text/html");
        request.setAttribute("users", "LogIn");

        if (isLog == 1){
            request.getRequestDispatcher("userHomePage.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
        }
    }


    /**
     * Metodo doPost che gestisce la richiesta POST della home page.
     *
     * @param request l'oggetto HttpServletRequest che contiene la richiesta effettuata dal client alla servlet
     * @param response l'oggetto HttpServletResponse che contiene la risposta inviata dalla servlet al client
     * @throws ServletException Se si verifica un errore nella servlet
     * @throws IOException Se si verifica un errore d'input/output
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}

