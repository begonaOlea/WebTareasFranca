package com.tareas.model;

public enum Estado {
    TODO("TODO"), INPROGRESS("INPROGRESS"), DONE("DONE");

    private String estado;

    private Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
