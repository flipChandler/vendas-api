package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.CountVendasDTO;
import br.com.xbrain.vendasapi.model.dto.VendedorDTO;
import br.com.xbrain.vendasapi.repositories.VendedorRepository;
import br.com.xbrain.vendasapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> findAll() {
        return repository.findAll();
    }

    public VendedorDTO findById(Long id) {
        Optional<Vendedor> optionalVendedor = repository.findById(id);
        if (optionalVendedor.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id);
        }
        return new VendedorDTO(optionalVendedor.get());
    }

    public List<CountVendasDTO> fetchListaVendedoresTotaisVendas() {
        List<CountVendasDTO> list = repository.fetchVendedoresVendas();
        return list;
    }
}
