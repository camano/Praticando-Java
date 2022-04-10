package com.jonathan.web.praticandojava.controller;

import com.jonathan.web.praticandojava.dto.ProductoDto;
import com.jonathan.web.praticandojava.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/addProducto")
    public ResponseEntity<?> addProducto(@RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.saveProducto(productoDto), HttpStatus.CREATED);
    }

}
