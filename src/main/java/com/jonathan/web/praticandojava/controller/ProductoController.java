package com.jonathan.web.praticandojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathan.web.praticandojava.dto.ProductoDto;
import com.jonathan.web.praticandojava.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> ListarProductos() {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{categoriaid}/addProducto")
    public ResponseEntity<?> addProducto(@RequestBody ProductoDto productoDto,@PathVariable(value = "categoriaid") Long id) {
        return new ResponseEntity<>(productoService.saveProducto(productoDto,id), HttpStatus.CREATED);
    }

}
