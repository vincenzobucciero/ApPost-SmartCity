
package com.example.smartcity.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/homepage")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         HttpSession session = request.getSession(false);
         int isLog = 0;
         if (session == null) {
             session = request.getSession();
             session.setAttribute("isLog", 0);
         } else {
             isLog = (int) session.getAttribute("isLog");
         }
         response.setContentType("text/html");
         request.setAttribute("loggato", isLog);
         request.setAttribute("users", "LogIn");
         request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}

