package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.ceiba.cliente.comando.manejador.ComandoClienteTestDataBuilder.aComandoCliente;


class ManejadorCrearClienteTest {

    private FabricaCliente fabricaCliente;
    private ServicioCrearCliente servicioCrearCliente;
    private ManejadorCrearCliente manejadorCrearCliente;

    @BeforeEach
    void inicializar() {
        fabricaCliente = Mockito.mock(FabricaCliente.class);
        servicioCrearCliente = Mockito.mock(ServicioCrearCliente.class);
        manejadorCrearCliente = new ManejadorCrearCliente(fabricaCliente, servicioCrearCliente);
    }

    @Test
    @DisplayName("Deberia crear un cliente de manera satisfactoria")
    void deberiaCrearClienteCorrectamente() {
        Long valorEsperado =15L;
        ComandoCliente comandoCliente = aComandoCliente().build();
        Cliente cliente = new Cliente(null, EnumTipoIdentificacion.CEDULA,"02012");
        Mockito.when(fabricaCliente.crear(comandoCliente)).thenReturn(cliente);
        Mockito.when(servicioCrearCliente.ejecutar(cliente)).thenReturn(valorEsperado);
        manejadorCrearCliente.ejecutar(comandoCliente);
        Mockito.verify(servicioCrearCliente,Mockito.times(1)).ejecutar(cliente);
    }
}