package com.jonathan.web.praticandojava.services;

import java.util.List;
import java.util.Map;

import com.jonathan.web.praticandojava.dto.ProductoDto;
import com.jonathan.web.praticandojava.entity.Producto;

public interface ProductoService {

    public List<ProductoDto> listarProductos();
    public List<Producto> listarProductos2();

    public Map<String, Object> saveProducto(ProductoDto productoDto,long id);


}
