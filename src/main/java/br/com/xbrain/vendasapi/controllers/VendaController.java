package br.com.xbrain.vendasapi.controllers;

import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<VendaDTO> create(@RequestBody VendaDTO dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
