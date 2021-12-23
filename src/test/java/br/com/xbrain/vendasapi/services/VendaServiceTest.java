package br.com.xbrain.vendasapi.services;

import br.com.xbrain.vendasapi.model.Venda;
import br.com.xbrain.vendasapi.model.Vendedor;
import br.com.xbrain.vendasapi.model.dto.VendaDTO;
import br.com.xbrain.vendasapi.model.dto.VendedorDTO;
import br.com.xbrain.vendasapi.repositories.VendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VendaServiceTest {

    public static final long ID = 1L;
    public static final String NOME = "João";
    public static final double VALOR = 150.0;
    @InjectMocks
    private VendaService vendaService;

    @Mock
    private VendaRepository vendaRepository;

    private Vendedor vendedor;
    private Venda venda;
    private VendaDTO vendaDTO;
    private VendedorDTO vendedorDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startVenda();
    }

    @Test
    void findAll() {
    }

    @Test
    void verificarAtributosDeVendedor() {
        assertEquals(ID, vendedor.getId());
        assertEquals(NOME, vendedor.getNome());
    }

    @Test
    void verificarAtributosDeVenda() {
        assertEquals(ID, venda.getId());
        assertEquals(VALOR, venda.getValor());
    }

    @Test
    void verificarAtributosDeVendaDTO() {
        assertEquals(ID, vendaDTO.getId());
        assertEquals(VALOR, vendaDTO.getValor());
        assertEquals(venda.getDataVenda(), vendaDTO.getDataVenda());
        assertEquals(venda.getVendedor().getNome(), vendaDTO.getVendedor().getNome());
    }

    @Test
    void quandoCriarUmaVendaRetorneSucesso() {
        when(vendaRepository.save(any())).thenReturn(venda);

        VendaDTO response = vendaService.create(vendaDTO);

        assertNotNull(response);
        assertEquals(VendaDTO.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(VALOR, response.getValor());
        assertEquals(vendedorDTO.getId(), response.getVendedor().getId());
    }

    private void startVenda() {
        vendedor = new Vendedor(ID, NOME);
        vendedorDTO = new VendedorDTO(vendedor);
        venda = new Venda(ID, LocalDate.now(), VALOR, vendedor);
        vendaDTO = new VendaDTO(ID, LocalDate.now(), VALOR, vendedorDTO);

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