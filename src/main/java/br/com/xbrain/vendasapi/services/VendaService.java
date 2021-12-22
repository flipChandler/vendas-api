package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<VendaDTO> findAll() {
        List<Venda> list = repository.findAll();
        return list.stream()
                .map(v -> new VendaDTO(v))
                .collect(Collectors.toList());
    }
}
