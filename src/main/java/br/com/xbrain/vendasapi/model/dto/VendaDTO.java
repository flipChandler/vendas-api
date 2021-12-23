package br.com.xbrain.vendasapi.model.dto;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;

import java.time.LocalDate;

public class VendaDTO {

    private Long id;
    private LocalDate dataVenda;
    private double valor;
    private VendedorDTO vendedor;

    public VendaDTO() {

    }

    public VendaDTO(Long id, LocalDate dataVenda, double valor, VendedorDTO vendedor) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valor = valor;
        this.vendedor = vendedor;
    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.valor = venda.getValor();
        this.vendedor = new VendedorDTO(venda.getVendedor());
    }

    public VendaDTO(Venda venda, Vendedor vendedor){
        this(venda);
        this.vendedor = new VendedorDTO(vendedor);
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

    public VendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
    }
}
