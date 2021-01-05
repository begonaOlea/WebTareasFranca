package com.tareas.model;

import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class Usuario {

    private int idUsuario;
    private String email;
    private String nombreApellidos;
    private String contrasenia;
    private SortedMap<String, Estado> agendaTareas;

    public Usuario(String email, String nombreApellidos, String contrasenia, int id) {
        this.idUsuario = id;
        this.email = email;
        this.nombreApellidos = nombreApellidos;
        this.contrasenia = contrasenia;
    }

    public Usuario(String email, String nombreApellidos, String contrasenia) {
        this.email = email;
        this.nombreApellidos = nombreApellidos;
        this.contrasenia = contrasenia;
        this.agendaTareas = new TreeMap<String, Estado>();
    }

    public SortedMap<String, Estado> getAgendaTareas() {
        return agendaTareas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + idUsuario + ", email=" + email + ", nombreApellidos=" + nombreApellidos + ", contrasenia=" + contrasenia + '}';
    }

}
