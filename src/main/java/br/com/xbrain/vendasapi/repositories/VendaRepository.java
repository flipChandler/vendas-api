package br.com.xbrain.vendasapi.repositories;

import br.com.xbrain.vendasapi.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
