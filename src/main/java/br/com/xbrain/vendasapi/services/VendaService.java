package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.model.dto.VendedorDTO;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Venda venda = repository.save(novaVenda(dto));
        return new VendaDTO(venda);
    }

    private Venda novaVenda(VendaDTO dto) {
        VendedorDTO vendedorDTO = vendedorService.findById(dto.getVendedor());

        Venda venda = new Venda();
        if (dto.getId() != null) {
            venda.setId(dto.getId());
        }
        venda.setVendedor(new Vendedor(vendedorDTO));
        venda.setDataVenda(dto.getDataVenda());
        venda.setValor(dto.getValor());

        return venda;
    }
}
