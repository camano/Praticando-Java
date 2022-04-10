package com.jonathan.web.praticandojava.dto;

public class TareasDto {

    private int tarea_id;
    private String tarea_descripcion;
    private int usuarioId;

    public TareasDto() {
    }

    public TareasDto(int tarea_id, String tarea_descripcion, int usuarioId) {
        this.tarea_id = tarea_id;
        this.tarea_descripcion = tarea_descripcion;
        this.usuarioId = usuarioId;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

}
