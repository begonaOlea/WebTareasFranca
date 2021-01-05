package com.tareas.services;

import com.tareas.exceptiones.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DB {

    private static Map<String, Usuario> usuarios;
    private static Map<String, Tarea> tareas;

    static {
        usuarios = new HashMap<String, Usuario>();
        tareas = new HashMap<String, Tarea>();

        usuarios.put("usuario1@gmail.com", new Usuario("usuario1@gmail.com", "Usuario 1", "1234", 1));
        usuarios.put("usuario2@gmail.com", new Usuario("usuario2@gmail.com", "Usuario 2", "1234", 2));

        //Tareas usuario 1
        tareas.put("Tarea1", new Tarea("Tarea1", Estado.DONE, 1));
        tareas.put("Tarea2", new Tarea("Tarea2", Estado.INPROGRESS, 1));
        tareas.put("Tarea3", new Tarea("Tarea3", Estado.DONE, 1));
        tareas.put("Tarea4", new Tarea("Tarea4", Estado.TODO, 1));

        //Tareas usuario 2
        tareas.put("Tarea5", new Tarea("Tarea5", Estado.DONE, 2));
        tareas.put("Tarea6", new Tarea("Tarea6", Estado.INPROGRESS, 2));
        tareas.put("Tarea7", new Tarea("Tarea7", Estado.DONE, 2));
        tareas.put("Tarea8", new Tarea("Tarea8", Estado.TODO, 2));

    }

    private DB() {
    }

    public static synchronized void altaUsuario(Usuario u) throws DBException {
        if (usuarios.containsKey(u.getEmail())) {
            throw new DBException("Ya existe un usuario para el email " + u.getEmail());
        }
        usuarios.put(u.getEmail(), u);
    }

    public static synchronized void altaTarea(Tarea t) throws DBException {
        if (tareas.containsValue(t.getDescripcion())) {
            throw new DBException("Ya existe la tarea: " + t.getDescripcion());
        }
        tareas.put(t.getDescripcion(), t);
    }

    public static synchronized Collection<Usuario> getAllUsuarios() {
        return usuarios.values();
    }

    public static synchronized Collection<Tarea> getTareasToDo(Usuario u) {
        Set<Tarea> listaTareasToDo = new HashSet<Tarea>();
        int idUsuario = u.getIdUsuario();

        for (Tarea tarea : tareas.values()) {

            if (idUsuario == tarea.getIdTarea()) {
                if (tarea.getEstado() == Estado.TODO) {
                    listaTareasToDo.add(tarea);
                }
            }
        }
        return listaTareasToDo;
    }

    public static synchronized Collection<Tarea> getTareasInProgress(Usuario u) {
        Set<Tarea> listaTareasInProgress = new HashSet<Tarea>();
        int idUsuario = u.getIdUsuario();

        for (Tarea tarea : tareas.values()) {

            if (idUsuario == tarea.getIdTarea()) {
                if (tarea.getEstado() == Estado.INPROGRESS) {
                    listaTareasInProgress.add(tarea);
                }
            }
        }
        return listaTareasInProgress;
    }

    public static synchronized Collection<Tarea> getTareasDone(Usuario u) {
        Set<Tarea> listaTareasDone = new HashSet<Tarea>();
        int idUsuario = u.getIdUsuario();

        for (Tarea tarea : tareas.values()) {

            if (idUsuario == tarea.getIdTarea()) {
                if (tarea.getEstado() == Estado.DONE) {
                    listaTareasDone.add(tarea);
                }
            }
        }
        return listaTareasDone;
    }

}//fin clase
