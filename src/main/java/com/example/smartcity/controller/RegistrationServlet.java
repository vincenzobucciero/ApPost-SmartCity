package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


/**
 * La servlet RegistrationServlet si occupa di gestire la registrazione
 * di un nuovo utente al sistema.
 */
@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    /**
     * Metodo che gestisce la richiesta GET, ovvero l'accesso alla pagina di registrazione.
     *
     * @param request  la richiesta HTTP ricevuta
     * @param response la risposta HTTP da restituire
     * @throws ServletException se si verifica un errore di servlet
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("registrazione.jsp").forward(request, response);
    }


    /**
     * Metodo che gestisce la richiesta POST, ovvero la registrazione di un nuovo utente.
     *
     * @param request  la richiesta HTTP ricevuta
     * @param response la risposta HTTP da restituire
     * @throws ServletException se si verifica un errore di servlet
     * @throws IOException se si verifica un errore d'input/output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sesso = request.getParameter("sesso");
        String telefono = request.getParameter("telefono");
        String dataNascita = request.getParameter("dataNascita");

        UserBean userBean = new UserBean();

        HttpSession vecchiaSession = request.getSession();

        if (vecchiaSession != null){
            vecchiaSession.invalidate();
        }
        HttpSession newSession = request.getSession();
        newSession.setMaxInactiveInterval(20 * 60);

        newSession.setAttribute("userBean", userBean);
        newSession.setAttribute("isLog", 1);
        request.setAttribute("loggato", 1);

        userBean.setNome(name);
        userBean.setCognome(surname);
        userBean.setEmail(email);
        userBean.setPassword(password);
        userBean.setSesso(sesso);
        userBean.setTelefono(telefono);
        userBean.setDataNascita(dataNascita);
        boolean risultato = UserDao.addRegistrazione(userBean);

        if( risultato ) {
            newSession.setAttribute("userBean", userBean);
            request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
        }
        else{
            newSession.setAttribute("risultato", risultato);
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
    }

}