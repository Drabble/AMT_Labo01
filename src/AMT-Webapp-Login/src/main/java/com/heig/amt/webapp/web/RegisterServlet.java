/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.web;

import com.heig.amt.webapp.services.UserServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antoi
 */
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserServiceLocal userService; 
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
        long id = userService.register(request.getParameter("username"), request.getParameter("password"));
        if(id != -1){
            request.getSession().setAttribute("id", id);
            response.sendRedirect(request.getContextPath() + "/Private");
        } else{
            request.setAttribute("registerError", "Username already exists");
            request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
        }
    }
}
