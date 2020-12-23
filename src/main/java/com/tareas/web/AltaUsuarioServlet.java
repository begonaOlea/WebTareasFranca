package com.tareas.web;

import com.tareas.exceptiones.DBException;
import com.tareas.model.Usuario;
import com.tareas.services.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.util.Length;

public class AltaUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. LEER PARAMETROS email, nombrecompleto, contraseña
        String paramEmail = request.getParameter("email");
        String paramNombreApellidos = request.getParameter("nombreApellidos");
        String paramPwd = request.getParameter("pwd");

        //2.  VALIDAR PARAMETROS
        String msgErrorNombreApellidos = null;
        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorAlta = null;

        boolean valido = true;

        //VALIDAR EMAIL
        if (paramEmail == null || paramEmail.trim().length() == 0) {
            msgErrorEmail = "Debe indicar el email del usuario";
            valido = false;
        }
        //VALIDAR NOMBRE y APELLIDOS
        if (paramNombreApellidos == null || paramNombreApellidos.trim().length() == 0) {
            msgErrorNombreApellidos = "Debe indicar nombre ";
            valido = false;
        }
        //VALIDAR PWD        
        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Debe indicar una clave";
            valido = false;
        }

        //3.  SI NO HAY ALGUN ERROR intentar grabar
        if (valido) {
            Usuario usuario = new Usuario(paramEmail, paramNombreApellidos, paramPwd);
            try {
                DB.altaUsuario(usuario);
                // add usuario ATRIBUTO DE SESION
                //El usuario no manda jSessionId , crea una nueva sesion
                //sino devuelve la sesión existente para es id
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
            } catch (DBException e) {
                msgErrorAlta = e.getMessage();
                valido = false;
            }
        }//fin datos validos

        // DESPACHAR LA RESPUESTA 
        //4. SI HAY ALGUN ERROR ir a form-alta-usuario.jsp
        //   SINO ir a lista-usuarios.jsp
        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "lista-usuarios.jsp";
        } else {
            jspAMostrar = "formulario-alta-usuario.jsp";
            request.setAttribute("msgErrorEmail", msgErrorEmail);
            request.setAttribute("msgErrorNombre", msgErrorNombreApellidos);
            request.setAttribute("msgErrorPwd", msgErrorPwd);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }

        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

}
