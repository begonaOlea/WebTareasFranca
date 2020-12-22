package com.tareas.services;

import com.tareas.exceptiones.DBException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private static Map<Integer, Tarea> tareas;
    private static Map<String, Usuario> usuarios;
    private static int ultimoIdTareas = 0;

    static {
        usuarios = new HashMap<String, Usuario>();
        usuarios.put("fpch", new Usuario("fpch","Franca", "Chiantera", "franca@gmail.com", "1234"));
        usuarios.put("jfud", new Usuario("jfud","Jose", "Useche", "jose@gmail.com", "1234"));

    }

    private DB() {
    }

    public static synchronized Collection<Tarea> getAllTareas() {
        return tareas.values();
    }

    public static synchronized Collection<Usuario> getAllUsuarios() {
        return usuarios.values();
    }

    public static synchronized void altaUsuario(Usuario u) throws DBException {
        if (usuarios.containsKey(u.getEmail())) {
            throw new DBException("Ya existe un usuario para el email " + u.getEmail());
        }
        usuarios.put(u.getEmail(), u);
    }

}//fin clase
