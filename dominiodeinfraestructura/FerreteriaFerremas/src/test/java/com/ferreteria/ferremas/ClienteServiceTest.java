package com.ferreteria.ferremas;

import com.ferreteria.ferremas.model.Cliente;
import com.ferreteria.ferremas.repository.ClienteRepository;
import com.ferreteria.ferremas.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllClientes() {
        Cliente cliente1 = new Cliente(1L, "Cliente1");
        Cliente cliente2 = new Cliente(2L, "Cliente2");
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.getAllClientes();

        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente(1L, "Cliente1");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente found = clienteService.getClienteById(1L);

        assertEquals("Cliente1", found.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente(1L, "Cliente1");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente saved = clienteService.saveCliente(cliente);

        assertEquals("Cliente1", saved.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deleteCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}

