package com.jonathan.web.praticandojava.services;

import java.util.List;
import java.util.Map;

import com.jonathan.web.praticandojava.dto.ProductoDto;


public interface ProductoService  {

    public List<ProductoDto> listarProductos();
    public Map<String,Object> saveProducto(ProductoDto productoDto);
    
}
