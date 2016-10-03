/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.web;

import com.heig.amt.webapp.services.UserManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antoi
 */
public class LoginServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(UserManager.getInstance().loginUser(request.getParameter("username"), request.getParameter("password"))){
            request.getSession().setAttribute("user", request.getParameter("username"));
            response.sendRedirect(request.getContextPath() + "/Private");
        } else{
            request.setAttribute("loginError", "Wrong username/password");
            request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
        }
    }

}
