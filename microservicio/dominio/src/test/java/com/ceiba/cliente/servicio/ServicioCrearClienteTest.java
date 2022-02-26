package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static com.ceiba.cliente.modelo.entidad.ClienteTestDataBuilder.aCliente;


class ServicioCrearClienteTest {

    private RepositorioCliente repositorioCliente;
    private ServicioCrearCliente servicioCrearCliente ;

    @BeforeEach
    void inicializar() {
        repositorioCliente = Mockito.mock(RepositorioCliente.class);
        servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
    }

    @Test
    @DisplayName("Debería crear un cliente correctamente")
    void deberiaCrearUnClienteCorrectamente() {
        Cliente cliente = aCliente().build();
        Long valorEsperado = 10L;
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(valorEsperado);
        Long valorDevuelto = servicioCrearCliente.ejecutar(cliente);
        Assertions.assertEquals(valorEsperado,valorDevuelto);
    }

    @Test
    @DisplayName("Debería lanza excepcion por cliente ya registrado")
    void deberiaLanzarExcepcionPorClienteYaRegistrado() {
        Cliente cliente = aCliente().build();
        Long valorEsperado = 10L;
        Mockito.when(repositorioCliente.existePorId(cliente.getId())).thenReturn(true);
        try {
            Long valorDevuelto = servicioCrearCliente.ejecutar(cliente);
        } catch(ExcepcionDuplicidad ex) {
            Assertions.assertEquals("El cliente ya se encuentra registrado",ex.getMessage());
        }
    }

}