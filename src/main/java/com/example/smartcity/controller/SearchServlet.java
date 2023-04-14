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
@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession( false );
        if ( session == null ) {
            session.setAttribute( "isLog",0 );
            request.getRequestDispatcher( "login.jsp" ).forward(request,response);
        } else {
            UserBean userBean = (UserBean) session.getAttribute( "userBean" );
            request.setAttribute( "userBean", userBean);
            request.getRequestDispatcher( "findPath.jsp" ).forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}