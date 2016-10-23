/*
 * File             : IndexServlet.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
// TODO
// Tester les erreurs...
// Commentaire / Entete
// Indenter, readme (postman, jmeter, API REST...), (commentaire pour les apis publique ? )
// Nettoyer repo github
// Gestion des erreurs API rest  
// Update docker
// Afficher erreur + id dans les réponses REST
// Ajouter get dans postman
// Tableau des utilisateurs avec datatable
// Mettre le package rest au bon endroit
// Ajout nom prenom adresse email pour les comptes
package com.heig.amt.webapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet forwards the index.jsp view
 *
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class IndexServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Show the index page.
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
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
