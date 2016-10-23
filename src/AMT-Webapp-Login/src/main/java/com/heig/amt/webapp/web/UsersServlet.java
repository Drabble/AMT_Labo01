/*
 * File             : UsersServlet.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.web;

import com.heig.amt.webapp.services.UserServiceLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet relies on the UserService EJB to forward a users main page after
 * he has logged into the app.
 *
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class UsersServlet extends HttpServlet {

    @EJB
    private UserServiceLocal userService;

    /**
     * Handles the HTTP <code>GET</code> method.
     * Shows the list of users page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("username", userService.get((Long) request.getSession().getAttribute("id")).getUsername());
            request.setAttribute("id", request.getSession().getAttribute("id"));
            request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            String message;

            // If there is a problem with the user id in the session variable
            if (e.getCause() != null && e.getCause().getClass().getSimpleName().equals(IllegalArgumentException.class.getSimpleName())) {
                message = e.getCause().getMessage();
            } 
            // Otherwise send internal server error message
            else {
                message = "Internal server error!";
            }

            throw new ServletException(message);
        }
    }
}
