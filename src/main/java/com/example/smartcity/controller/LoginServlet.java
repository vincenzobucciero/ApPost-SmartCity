package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.ParkingDao;
import com.example.smartcity.model.DAO.UserDao;
import com.example.smartcity.service.ChainOfResponsability.AccessoLogin;
import com.example.smartcity.service.ChainOfResponsability.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * La servlet LoginServlet si occupa della gestione della richiesta di login da parte degli utenti.
 * In particolare, in caso di login con successo, la servlet reindirizza l'utente alla pagina corretta
 * (pagina dell'utente o pagina dell'amministratore).
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    /**
     * Questo metodo gestisce la richiesta HTTP GET e inoltra la richiesta alla pagina di login.
     *
     * @param request  l'oggetto HttpServletRequest che contiene la richiesta del client.
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server.
     * @throws ServletException se la richiesta non può essere gestita.
     * @throws IOException se si verifica un errore d'I/O mentre si gestisce la richiesta.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Questo metodo gestisce la richiesta HTTP POST che riceve i dati di login dell'utente.
     *
     * @param request  l'oggetto HttpServletRequest che contiene la richiesta del client.
     * @param response l'oggetto HttpServletResponse che contiene la risposta del server.
     * @throws ServletException se la richiesta non può essere gestita.
     * @throws IOException se si verifica un errore d'I/O mentre si gestisce la richiesta.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserBean userBean = UserDao.getUserBean( email );
        AccessoLogin accessoLogIn = UserService.logHandler( email, password );
        List<ParkingBean> list = ParkingDao.getListParking();

        switch ( accessoLogIn ) {
            case UTENTE_INESISTENTE:
                request.setAttribute("stato", "UTENTE_INESISTENTE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case PASSWORD_ERRATA:
                request.setAttribute("stato", "PASSWORD_ERRATA");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case SUCCESSO:
                HttpSession vecchiaSession = request.getSession();

                if (vecchiaSession != null){
                    vecchiaSession.invalidate();
                }
                HttpSession newSession = request.getSession();
                newSession.setMaxInactiveInterval(20*60);

                newSession.setAttribute("userBean", userBean);
                newSession.setAttribute("isLog",1);     //1 = sono un utente normale
                request.setAttribute("loggato",1);
                System.out.println("Login Servlet: " + userBean.getNome());
                request.setAttribute("stato", "SUCCESSO");
                newSession.setAttribute("email", userBean.getEmail()); // Passiamo l'email visualizzare le prenotazioni
                request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
                break;
            case SUCCESSO_ADMIN:
                HttpSession vecchiaSessionAd = request.getSession();

                if (vecchiaSessionAd != null){
                    vecchiaSessionAd.invalidate();
                }
                HttpSession newSessionAd = request.getSession();
                newSessionAd.setMaxInactiveInterval(20*60);

                newSessionAd.setAttribute("userBean", userBean);
                newSessionAd.setAttribute("isLog",2);       //2 = sono un admin

                request.setAttribute("loggato",2);
                request.setAttribute("stato", "SUCCESSO_ADMIN");
                newSessionAd.setAttribute("email", userBean.getEmail());
                newSessionAd.setAttribute("list", list);
                request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("stato", "ERRORE");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }
}