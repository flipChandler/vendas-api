package br.com.xbrain.vendasapi.repositories;

import br.com.xbrain.vendasapi.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
