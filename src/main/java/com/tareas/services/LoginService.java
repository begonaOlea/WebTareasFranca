package com.tareas.services;

import com.tareas.exceptiones.LoginException;
import com.tareas.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void login(String email, String clave, HttpSession session) throws LoginException {
        //DB ver si existe y coincide email y clave
        Collection<Usuario> usuarios = DB.getAllUsuarios();
        Usuario usrEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                usrEncontrado = u;
                break;
            }

        }

        //Sino existe lanzo excepcion
        if (usrEncontrado == null) {
            throw new LoginException("El usuario no existe. Debe registrarse");
        } else {
            //Ver si clave Ok
            if (usrEncontrado.getContrasenia().equals(clave)) {
                //Añadir Sesion
                session.setAttribute("usuario", usrEncontrado);
            } else {
                throw new LoginException("Clave no válida");
            }
        }

    }

    public void logout(HttpSession session) {
        session.invalidate();

    }

}
