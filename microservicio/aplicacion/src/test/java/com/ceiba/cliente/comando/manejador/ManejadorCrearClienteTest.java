package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.servicio.ServicioConsultarCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.ceiba.cliente.comando.manejador.ComandoClienteTestDataBuilder.aComandoCliente;


class ManejadorCrearClienteTest {

    private ServicioConsultarCliente servicioConsultarCliente;
    private ManejadorConsultaCliente manejadorCrearCliente;

    @BeforeEach
    void inicializar() {
        servicioConsultarCliente = Mockito.mock(ServicioConsultarCliente.class);
        manejadorCrearCliente = new ManejadorConsultaCliente(servicioConsultarCliente);
    }

    @Test
    @DisplayName("Deberia crear un cliente de manera satisfactoria")
    void deberiaCrearClienteCorrectamente() {
        Long valorEsperado =15L;
        ComandoCliente comandoCliente = aComandoCliente().build();
        DtoCliente dtoCliente = new DtoCliente(15L, "C","02012");
        Mockito.when(servicioConsultarCliente.ejecutar(Mockito.anyString(), Mockito.anyString())).thenReturn(dtoCliente);
        manejadorCrearCliente.ejecutar(comandoCliente);
        Mockito.verify(servicioConsultarCliente,Mockito.times(1))
                .ejecutar(comandoCliente.getTipoIdentificacion(), comandoCliente.getNumeroIdentificacion());
    }
}