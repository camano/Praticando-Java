package com.jonathan.web.praticandojava.security.repository;

import java.util.Optional;

import com.jonathan.web.praticandojava.security.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

	public Optional<Rol> findByNombre(String nombre);

}
