/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.model.Estado;
import com.tareas.services.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franca
 */
public class EliminarTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Leer parametros tarea
        String paramDescripcion = req.getParameter("descripcion");
        String paramEstado = req.getParameter("estado");

        //2.Validar parámetros
        String msgErrorDescripcion = null;
        String msgErrorEstado = null;
        String msgErrorCambiarEstado = null;

        boolean valido = true;

        //Validar Descripcion
        if (paramDescripcion == null || paramDescripcion.trim().length() == 0) {
            msgErrorDescripcion = "Debe indicar descripcion";
            valido = false;
        }

        //Validar Estado
        Estado estado;
        if (paramEstado == null || paramEstado.trim().length() == 0) {
            msgErrorEstado = "Debe indicar estado de tarea";
            valido = false;
        } else {
            estado = Estado.valueOf(paramEstado);
        }

        //Si no hay nigun error Cambiar Estado Tarea
        if (valido) {
            DB.eliminarTareaDone(paramDescripcion, Estado.valueOf(paramEstado));

        }

        //DESPACHAR LA RESPUESTA
        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "lista-tareas.jsp";
        } else {
            jspAMostrar = "lista-tareas.jsp";
            req.setAttribute("msgErrorDescripcion", msgErrorDescripcion);
            req.setAttribute("msgErrorEstado", msgErrorEstado);
            req.setAttribute("msgErrorCambiarEstado", msgErrorCambiarEstado);

        }

        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }
}
