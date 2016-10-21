/*
 * File             : RegisterServlet.java
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
 *
 * @author antoi
 */
public class RegisterServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("id", request.getSession().getAttribute("id"));
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

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
        try {
            long id = userService.create(request.getParameter("username"), 
                    request.getParameter("password"), request.getParameter("email"), 
                    request.getParameter("firstname"), request.getParameter("lastname"));
            request.getSession().setAttribute("id", id);
            response.sendRedirect(request.getContextPath() + "/users");
        }  catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            String message;

            // If we throwed an illegal argument exception retrieve message
            if (e.getCause() != null && e.getCause().getClass().getSimpleName().equals("IllegalArgumentException")) {
                message = e.getCause().getMessage();
            }
            // Otherwise send internal server error message
            else {
                message = "Internal server error!";
            }

            request.setAttribute("error", message);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);;
        }
    }
}
