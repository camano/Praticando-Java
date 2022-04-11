package com.jonathan.web.praticandojava.dto;

public class CategotiaDto {

    private Long id;
    private String nombreCategoria;

    public CategotiaDto() {
    }

    public CategotiaDto(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

}
