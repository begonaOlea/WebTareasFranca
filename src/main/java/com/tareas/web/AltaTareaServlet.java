package com.tareas.web;

import com.tareas.exceptiones.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.DB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AltaTareaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        int idUsuario = u.getIdUsuario();
        
        //1. LEER PARAMETROS idUsuario, descripcion
        String paramDescripcion = request.getParameter("descripcion");

        //2.  VALIDAR PARAMETROS
        String msgErrorDescripcion = null;
        String msgErrorAlta = null;

        boolean valido = true;

        //VALIDAR DESCRIPCION
        if (paramDescripcion == null || paramDescripcion.trim().length() == 0) {
            msgErrorDescripcion = "Debe indicar descripcion de la tarea ";
            valido = false;
        }

        //3.  SI NO HAY ALGUN ERROR intentar grabar
        if (valido) {
            Tarea tarea = new Tarea(paramDescripcion, Estado.TODO, idUsuario);
            try {
                DB.altaTarea(tarea);
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
            jspAMostrar = "lista-tareas.jsp";
        } else {
            jspAMostrar = "formulario-alta-tarea.jsp";
            request.setAttribute("msgErrorDescripcion", msgErrorDescripcion);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }

        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

}
