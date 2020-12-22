package com.tareas.services;

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
        usuarios.put("fpch", new Usuario("Franca", "Chiantera", "franca@gmail.com", "1234"));
        usuarios.put("jfud", new Usuario("Jose", "Useche", "jose@gmail.com", "1234"));

    }

    private DB() {
    }

    public static synchronized Collection<Tarea> getAllTareas() {
        return tareas.values();
    }

    public static synchronized Collection<Usuario> getAllUsuarios() {
        return usuarios.values();
    }

}//fin clase
