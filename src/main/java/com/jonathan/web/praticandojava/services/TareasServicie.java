package com.jonathan.web.praticandojava.services;

import java.util.List;

import com.jonathan.web.praticandojava.dto.TareasDto;

public interface TareasServicie {

    public TareasDto tareasDto(Long id);
    public List<TareasDto> listarTareas();
    
    
}
