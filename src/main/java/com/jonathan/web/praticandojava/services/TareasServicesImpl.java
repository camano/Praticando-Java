package com.jonathan.web.praticandojava.services;

import java.util.List;

import com.jonathan.web.praticandojava.dto.TareasDto;
import com.jonathan.web.praticandojava.utils.Global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TareasServicesImpl implements TareasServicie {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TareasDto tareasDto(Long id) {
        HttpEntity<TareasDto> entity = new HttpEntity<TareasDto>(getHeaders());
        ResponseEntity<TareasDto> responseEntity = restTemplate.exchange(Global.URL_NODE + id, HttpMethod.GET, entity,
                TareasDto.class);
        TareasDto tareasDto = responseEntity.getBody();
        System.out.println("datos " + tareasDto.getTarea_descripcion());
        return tareasDto;
    }

    @Override
    public List<TareasDto> listarTareas() {
        HttpEntity<TareasDto> entity = new HttpEntity<TareasDto>(getHeaders());
        ResponseEntity<List<TareasDto>> responseEntity = restTemplate.exchange(Global.URL_NODE , HttpMethod.GET, entity,
        new ParameterizedTypeReference<List<TareasDto>>() {});
        List<TareasDto> lDtos= responseEntity.getBody();
        System.out.println("datod ::"+lDtos.get(0).getTarea_descripcion());
        return lDtos;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setBasicAuth("bazuco28", "12345");
        return headers;
    }

}
