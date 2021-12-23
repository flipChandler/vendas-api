package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.model.dto.VendedorDTO;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VendaServiceTest {

    @InjectMocks
    private VendaService vendaService;

    @InjectMocks
    private VendaRepository vendaRepository;

    private Vendedor vendedor;
    private Venda venda;
    private VendaDTO vendaDTO;
    private VendedorDTO vendedorDTO;

    @BeforeEach
    void setUp() {
        startVenda();
    }

    @Test
    void findAll() {
    }

    @Test
    void verificarAtributosDeVendedor() {
        assertEquals(1L, vendedor.getId());
        assertEquals("João", vendedor.getNome());
    }

    @Test
    void verificarAtributosDeVenda() {
        assertEquals(1L, venda.getId());
        assertEquals(150.0, venda.getValor());
    }

    @Test
    void verificarAtributosDeVendaDTO() {
        assertEquals(1L, vendaDTO.getId());
        assertEquals(150.0, vendaDTO.getValor());
        assertEquals(venda.getDataVenda(), vendaDTO.getDataVenda());
        assertEquals(venda.getVendedor().getNome(), vendaDTO.getVendedor().getNome());
    }

    // @Test
    void create() {
        when(vendaRepository.save(any())).thenReturn(venda);

        VendaDTO response = vendaService.create(vendaDTO);

        assertEquals(VendaDTO.class, response.getClass());
    }

    private void startVenda() {
        vendedor = new Vendedor(1L, "João");
        venda = new Venda(1L, LocalDate.now(), 150.0, vendedor);
        vendaDTO = new VendaDTO(venda);
        vendedorDTO = new VendedorDTO(vendedor);
    }

    private Venda novaVenda(VendaDTO dto) {
        Venda venda = new Venda();
        if (dto.getId() != null) {
            venda.setId(dto.getId());
        }
        venda.setVendedor(new Vendedor(vendedorDTO));
        venda.setDataVenda(dto.getDataVenda());
        venda.setValor(dto.getValor());

        return venda;
    }
}