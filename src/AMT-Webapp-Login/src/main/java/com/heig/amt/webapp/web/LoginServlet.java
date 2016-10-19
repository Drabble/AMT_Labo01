/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.web;

import com.heig.amt.webapp.services.UserServiceLocal;
import java.io.IOException;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antoi
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private UserServiceLocal userService;

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
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

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
        try{
            long id = userService.login(request.getParameter("username"), request.getParameter("password"));
            if (id != -1) {
                request.getSession().setAttribute("id", id);
                response.sendRedirect(request.getContextPath() + "/users");
            } else {
                request.setAttribute("error", "Wrong username/password");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        } catch(SQLException e){
            request.setAttribute("error", e.getSQLState());
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);;
        }
    }

}
