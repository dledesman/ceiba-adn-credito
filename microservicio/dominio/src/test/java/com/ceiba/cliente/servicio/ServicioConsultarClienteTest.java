package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.ceiba.cliente.modelo.entidad.DtoClienteTestDataBuilder.aDtoCliente;

class ServicioConsultarClienteTest {

    private RepositorioCliente repositorioCliente;
    private ServicioConsultarCliente servicioConsultarCliente;

    @BeforeEach
    void inicializar() {
        repositorioCliente = Mockito.mock(RepositorioCliente.class);
        servicioConsultarCliente = new ServicioConsultarCliente(repositorioCliente);
    }

    @Test
    @DisplayName("Debería consultar un cliente previamente registrado un cliente correctamente")
    void deberiaConultarUnClienteCorrectamente() {
        DtoCliente dtoClienteEsperado  = aDtoCliente().conNumeroIdentificacion("56166").build();
        Mockito.when(repositorioCliente.consultar(dtoClienteEsperado.getTipoIdentificacion(),
                dtoClienteEsperado.getNumeroIdentificacion())).thenReturn(dtoClienteEsperado);
        DtoCliente clienteDevuelto = servicioConsultarCliente.ejecutar(dtoClienteEsperado.getTipoIdentificacion(),
                dtoClienteEsperado.getNumeroIdentificacion());
        Assertions.assertEquals(dtoClienteEsperado,clienteDevuelto);
    }

}