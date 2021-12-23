package br.com.xbrain.vendasapi.model.dto;

import br.com.xbrain.vendasapi.model.Vendedor;

import java.io.Serializable;

public class CountVendasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private Long totalVendas;
    // private Double mediaDiaria;

    public CountVendasDTO() {
    }

    public CountVendasDTO(String nome, Long totalVendas) {
        this.nome = nome;
        this.totalVendas = totalVendas;
    }

    public CountVendasDTO(Vendedor vendedor, Long totalVendas) {
        this.nome = vendedor.getNome();
        this.totalVendas = totalVendas;
        // this.mediaDiaria = mediaDiaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Long totalVendas) {
        this.totalVendas = totalVendas;
    }
}
