/*
package com.example.smartcity.controller;

import com.example.smartcity.model.Bean.UserBean;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 *
 *
 */

/*
@WebServlet(name = "ModifyUserServlet", value = "/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        HttpSession session = request.getSession(false);
        if ( session == null ) {
            session.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            UserBean userBean = (UserBean) session.getAttribute("usersBean");
            request.setAttribute("usersBean", userBean);
            //request.getRequestDispatcher("userHomePage.jsp").forward(request,response);


            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String password = request.getParameter("password");


            ModifyUserService.modifyNome(email, nome);
            ModifyUserService.modifyCognome(email, cognome);
            ModifyUserService.modifyPassword(email, password);


            request.getRequestDispatcher("modifyUserInfo.jsp").forward(request, response);
        }

    }
}

*/