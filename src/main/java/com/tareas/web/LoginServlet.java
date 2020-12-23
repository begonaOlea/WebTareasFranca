/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.exceptiones.LoginException;
import com.tareas.model.Usuario;
import com.tareas.services.LoginService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Franca
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Leer parametro
        boolean valido = true;
        Usuario usuario;
        String email = req.getParameter("email");
        String clave = req.getParameter("pwd");

        //Validar parámetros
        String msgErrorEmail = null;
        String msgErrorClave = null;

        //Validar email y contraseña
        if (email == null || email.trim().length() == 0) {
            msgErrorEmail = "Debe indicar un email";
            valido = false;
        }

        if (clave == null || clave.trim().length() == 0) {
            msgErrorClave = "Debe indicar su contraseña";
            valido = false;
        }

        //Si todo ok
        HttpSession sesion = req.getSession();
        LoginService servicio = new LoginService();
        try {
            servicio.login(email, clave, sesion);
        } catch (LoginException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // DESPACHAR LA RESPUESTA 
        //4. SI HAY ALGUN ERROR ir lista.jsp
        //   SINO ir a lista.jsp
        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "lista-tareas.jsp";
        } else {
            jspAMostrar = "login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorClave", msgErrorClave);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);

    }//fin del post
}
