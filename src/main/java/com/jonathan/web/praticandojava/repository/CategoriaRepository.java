package com.jonathan.web.praticandojava.repository;

import com.jonathan.web.praticandojava.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
