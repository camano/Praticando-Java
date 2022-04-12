package com.jonathan.web.praticandojava.controller;

import com.jonathan.web.praticandojava.services.TareasServicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareasServicie tareasServicie;

    @GetMapping("/{idTarea}")
    public ResponseEntity<?> tareasId(@PathVariable(value = "idTarea") Long id ) {
        return new ResponseEntity<>(tareasServicie.tareasDto(id), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> tareas() {
        return new ResponseEntity<>(tareasServicie.listarTareas(), HttpStatus.OK);
    }

}
