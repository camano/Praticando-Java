package com.jonathan.web.praticandojava.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.jonathan.web.praticandojava.dto.ProductoDto;
import com.jonathan.web.praticandojava.entity.Categoria;
import com.jonathan.web.praticandojava.entity.Producto;
import com.jonathan.web.praticandojava.repository.CategoriaRepository;
import com.jonathan.web.praticandojava.repository.ProductoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoserviceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoDto> listarProductos() {
        List<Producto>lProductos=productoRepository.findAll();
        return lProductos.stream().map(producto->mapeaDto(producto)).collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> saveProducto(ProductoDto productoDto) {
        Map<String, Object> mensaje = new HashMap<>();
        Categoria categoria= categoriaRepository.findById(productoDto.getCategoriaId()).orElse(null);
        if(categoria == null){
            mensaje.put("Mensaje", "No se encontro esa categoria");
            return mensaje;
        }
        Producto producto = mapearEntidad(productoDto);
        producto.setCategoria(categoria);
        Producto guardarProducto = productoRepository.save(producto);
        ProductoDto productoDto2 = mapeaDto(guardarProducto);
        mensaje.put("Mensaje", "Se creo un nuevo producto");
        mensaje.put("Producto", productoDto2);        
        return mensaje;
    }

    // Convierte entidad a DTO
    private ProductoDto mapeaDto(Producto producto) {
        return modelMapper.map(producto, ProductoDto.class);
    }

    // Convierte de DTO a Entidad
    private Producto mapearEntidad(ProductoDto productoDto) {
        return modelMapper.map(productoDto, Producto.class);
    }
}
