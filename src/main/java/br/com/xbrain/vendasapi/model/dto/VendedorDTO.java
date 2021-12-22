package br.com.xbrain.vendasapi.model.dto;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorDTO {

    private Long id;
    private String nome;
    private List<VendaDTO> vendas = new ArrayList<>();

    public VendedorDTO() {
    }

    public VendedorDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public VendedorDTO(Vendedor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public VendedorDTO(Vendedor entity, List<Venda> vendas) {
        this(entity);
        vendas.forEach(venda -> this.vendas.add(new VendaDTO(venda)));
    }


}
