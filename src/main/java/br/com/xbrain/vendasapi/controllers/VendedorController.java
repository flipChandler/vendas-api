package br.com.xbrain.vendasapi.controllers;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.CountVendasDTO;
import br.com.xbrain.vendasapi.model.dto.VendedorDTO;
import br.com.xbrain.vendasapi.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/vendas")
    public ResponseEntity<List<CountVendasDTO>> fetchVendedoresVendas() {
        return ResponseEntity.ok(service.fetchListaVendedoresTotaisVendas());
    }
}
