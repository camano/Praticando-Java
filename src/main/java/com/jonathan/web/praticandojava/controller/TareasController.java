package com.jonathan.web.praticandojava.controller;

import java.util.List;

import com.jonathan.web.praticandojava.dto.TareasDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumiendo/tareas")
public class TareasController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public ResponseEntity<?> listarTareas() {
        List<TareasDto> tareas = restTemplate.getForObject("http://localhost:3001/api/tareas", List.class);
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }
}
