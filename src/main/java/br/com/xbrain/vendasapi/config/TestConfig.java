package br.com.xbrain.vendasapi.config;

import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private VendedorRepository repository;

    @Bean
    public void startDB() {

        Vendedor vendedor1 = new Vendedor(1L, "João");
        Vendedor vendedor2 = new Vendedor(2L, "Sonia");
        Vendedor vendedor3 = new Vendedor(3L, "Vilma");

        repository.saveAll(List.of(vendedor1, vendedor2, vendedor3));
    }
}