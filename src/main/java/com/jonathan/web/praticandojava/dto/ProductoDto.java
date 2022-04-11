package com.jonathan.web.praticandojava.dto;

import java.math.BigDecimal;

public class ProductoDto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String imagen;
    private CategotiaDto categoria;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, BigDecimal precio, String imagen, CategotiaDto categotiaDto) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.categoria = categotiaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public CategotiaDto getCategoria() {
        return categoria;
    }

    public void setCategotiaDto(CategotiaDto categoria) {
        this.categoria = categoria;
    }

}
