package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static com.ceiba.cliente.modelo.entidad.ClienteTestDataBuilder.aCliente;
import static org.assertj.core.api.Fail.fail;

class ServicioActualizarClienteTest {

    private RepositorioCliente repositorioCliente;

    private ServicioActualizarCliente servicioActualizarCliente;

    @BeforeEach
    void inicializar() {
        repositorioCliente = Mockito.mock(RepositorioCliente.class);
        servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
    }

    @Test
    @DisplayName("Debería actualizar un cliente correcatmente")
    void deberiaActualizarUnclienteCorrectamente() {
        Cliente cliente =  aCliente().conCodigo(10L).build();
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioActualizarCliente.ejecutar(cliente);
        Mockito.verify(repositorioCliente,Mockito.times(1)).actualizar(cliente);
    }

    @Test
    @DisplayName("Debería actualiza un cliente correcatmente")
    void deberiaLanzarExcepcionPorClienteNoExistente() {
        Cliente cliente =  aCliente().build();
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(false);
        try {
            servicioActualizarCliente.ejecutar(cliente);
            fail("Debería actualiza un cliente correcatmente");
        } catch (ExcepcionSinDatos ex) {
            Assertions.assertEquals("No existe el cliente seleccionado para actualización",ex.getMessage());
        }
    }

}