package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private VendedorService vendedorService;

    public List<VendaDTO> findAll() {
        List<Venda> list = repository.findAll();
        return list.stream()
                .map(v -> new VendaDTO(v))
                .collect(Collectors.toList());
    }

    @Transactional
    public VendaDTO create(VendaDTO dto) {
        Venda venda = new Venda();
        copyDTOToEntity(dto, venda);
        venda = repository.save(venda);
        return new VendaDTO(venda);
    }

    private void copyDTOToEntity(VendaDTO dto, Venda entity) {
        entity.setDataVenda(LocalDate.now());
        entity.setValor(dto.getValor());
        entity.setVendedor(new Vendedor(dto.getVendedor()));
    }
}
