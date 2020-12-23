package com.tareas.services;

import com.tareas.exceptiones.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private static Map<String, Tarea> tareas;
    private static Map<String, Usuario> usuarios;

    static {
        usuarios = new HashMap<String, Usuario>();
        usuarios.put("franca@gmail.com", new Usuario("franca@gmail.com", "Franca Chiantera", "1234"));
        usuarios.put("jose@gmail.com", new Usuario("jose@gmail.com", "Jose Useche", "1234"));

        tareas = new HashMap<String, Tarea>();
        tareas.put("Tarea1", new Tarea("Tarea1", Estado.DONE));
        tareas.put("Tarea2", new Tarea("Tarea2", Estado.INPROGRESS));
        tareas.put("Tarea3", new Tarea("Tarea3", Estado.DONE));
        tareas.put("Tarea4", new Tarea("Tarea4", Estado.TODO));
    }

    private DB() {
    }

    public static synchronized Collection<Tarea> getAllTareas() {
        return tareas.values();
    }

    public static synchronized void altaTarea(Tarea t) throws DBException {
        if (tareas.containsKey(t.getDescripcion())) {
            throw new DBException("Ya existe la tarea: " + t.getDescripcion());
        }
        tareas.put(t.getDescripcion(), t);
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
