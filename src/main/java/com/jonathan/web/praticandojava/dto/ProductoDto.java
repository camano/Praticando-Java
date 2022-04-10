package com.jonathan.web.praticandojava.dto;

import java.math.BigDecimal;

public class ProductoDto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String imagen;
    private Long categoriaId;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, BigDecimal precio, String imagen, Long categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.categoriaId = categoriaId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

}
