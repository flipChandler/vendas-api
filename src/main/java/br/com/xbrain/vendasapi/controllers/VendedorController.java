package br.com.xbrain.vendasapi.controllers;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
