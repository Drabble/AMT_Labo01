/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.web;

import com.heig.amt.webapp.services.UserServiceLocal;
import java.io.IOException;
import java.sql.SQLException;
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
public class UsersServlet extends HttpServlet {

    @EJB
    private UserServiceLocal userService;

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
        try {
            request.setAttribute("username", userService.get((Long) request.getSession().getAttribute("id")).getUsername());
            request.setAttribute("id", request.getSession().getAttribute("id"));
            request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
