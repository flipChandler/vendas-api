package br.com.xbrain.vendasapi.repositories;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.CountVendasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT new br.com.xbrain.vendasapi.model.dto.CountVendasDTO(v.nome, COUNT(vend.id)) " +
            " FROM Vendedor AS v JOIN v.vendas AS vend GROUP BY v.nome")
    List<CountVendasDTO> fetchVendedoresVendas();
}
