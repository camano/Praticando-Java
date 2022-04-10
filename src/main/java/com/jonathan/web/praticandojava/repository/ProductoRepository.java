package com.jonathan.web.praticandojava.repository;

import com.jonathan.web.praticandojava.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository   extends JpaRepository<Producto,Long>{
}
