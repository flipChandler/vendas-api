package br.com.xbrain.vendasapi.model.dto;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VendedorDTO implements Serializable {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VendaDTO> getVendas() {
        return vendas;
    }

}
