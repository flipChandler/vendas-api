package br.com.xbrain.vendasapi.model;

import br.com.xbrain.vendasapi.model.dto.VendedorDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //@JsonIgnore
    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<Venda> vendas = new ArrayList<>();

    public Vendedor() {
    }

    public Vendedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Vendedor(VendedorDTO vendedorDTO) {
        this.id = vendedorDTO.getId();
        this.nome = vendedorDTO.getNome();
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

    public List<Venda> getVendas() {
        return vendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendedor)) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(id, vendedor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
