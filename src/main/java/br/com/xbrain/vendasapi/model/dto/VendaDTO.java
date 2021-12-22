package br.com.xbrain.vendasapi.model.dto;

import br.com.xbrain.vendasapi.model.Venda;

import java.time.LocalDate;

public class VendaDTO {

    private Long id;
    private LocalDate dataVenda;
    private double valor;
    private Long vendedor;
    private String nomeVendedor;

    public VendaDTO() {

    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.valor = venda.getValor();
        this.vendedor = venda.getVendedor().getId();
        this.nomeVendedor = venda.getVendedor().getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getVendedor() {
        return vendedor;
    }

    public void setVendedor(Long vendedor) {
        this.vendedor = vendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
