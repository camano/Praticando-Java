package com.jonathan.web.praticandojava.dto;

public class TareasDto {

    private int tarea_id;
    private String tarea_descripcion;
    private int usuario_id;
    private UsuarioDto usuario;

    public TareasDto() {
    }

    public TareasDto(String tarea_descripcion, int usuario_id, UsuarioDto usuario) {
        this.tarea_descripcion = tarea_descripcion;
        this.usuario_id = usuario_id;
        this.usuario = usuario;
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

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    

}
