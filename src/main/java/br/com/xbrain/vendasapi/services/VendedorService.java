package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> findAll() {
        return repository.findAll();
    }
}
