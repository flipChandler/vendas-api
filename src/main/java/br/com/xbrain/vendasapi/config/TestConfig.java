package br.com.xbrain.vendasapi.config;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import br.com.xbrain.vendasapi.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Bean
    public void startDB() {

        Vendedor vendedor1 = new Vendedor(null, "João");
        Vendedor vendedor2 = new Vendedor(null, "Sonia");
        Vendedor vendedor3 = new Vendedor(null, "Vilma");

        Venda venda1 = new Venda(null, LocalDate.now(), 25.51, vendedor1);
        Venda venda2 = new Venda(null, LocalDate.now(), 35.52, vendedor2);
        Venda venda3 = new Venda(null, LocalDate.now(), 45.53, vendedor3);
        Venda venda4 = new Venda(null, LocalDate.now(), 55.54, vendedor1);

        vendedorRepository.saveAll(List.of(vendedor1, vendedor2, vendedor3));

        vendaRepository.saveAll(List.of(venda1, venda2, venda3, venda4));


    }
}