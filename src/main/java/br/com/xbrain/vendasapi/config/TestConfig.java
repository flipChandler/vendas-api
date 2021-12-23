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
        Vendedor vendedor4 = new Vendedor(null, "Jeremy");
        Vendedor vendedor5 = new Vendedor(null, "Sue");


        Venda venda1 = new Venda(null, LocalDate.now(), 25.51, vendedor1);
        Venda venda2 = new Venda(null, LocalDate.now(), 35.22, vendedor2);
        Venda venda3 = new Venda(null, LocalDate.now(), 45.73, vendedor3);
        Venda venda4 = new Venda(null, LocalDate.EPOCH, 55.94, vendedor1);
        Venda venda5 = new Venda(null, LocalDate.EPOCH, 100.16, vendedor4);
        Venda venda6 = new Venda(null, LocalDate.EPOCH, 870.72, vendedor3);
        Venda venda7 = new Venda(null, LocalDate.EPOCH, 124.34, vendedor2);
        Venda venda8 = new Venda(null, LocalDate.EPOCH, 951.08, vendedor1);
        Venda venda9 = new Venda(null, LocalDate.EPOCH, 753.11, vendedor3);
        Venda venda10 = new Venda(null, LocalDate.EPOCH, 93.49, vendedor5);

        vendedorRepository.saveAll(List.of(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5));

        vendaRepository.saveAll(List.of(venda1, venda2, venda3, venda4, venda5,
                venda6, venda7, venda8, venda9, venda10));


    }
}