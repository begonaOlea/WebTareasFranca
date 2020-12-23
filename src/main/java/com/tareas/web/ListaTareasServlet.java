/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.DB;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class ListaTareasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        Usuario usr = (Usuario) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            resp.sendRedirect("login.jsp");
        } else {
            Collection<Tarea> listaTareas = DB.getAllTareas();
            req.setAttribute("listaTareas", listaTareas);
        }
        RequestDispatcher rd = req.getRequestDispatcher("lista-tareas.jsp");
        rd.forward(req, resp);
    }

}
