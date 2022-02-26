package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarClienteTest {

    private RepositorioCliente repositorioCliente;
    private ServicioEliminarCliente servicioEliminarCliente;

    @BeforeEach
    void inicializar() {
        repositorioCliente = Mockito.mock(RepositorioCliente.class);
        servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
    }

    @Test
    @DisplayName("Deberia eliminar un cliente correctamente")
    void deberiaEliminarUnClienteCorrectamente() {
        Long id = 10L;
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCliente.tieneSolicitudesIngresadas(Mockito.anyLong())).thenReturn(false);
        servicioEliminarCliente.ejecutar(id);
        Mockito.verify(repositorioCliente,Mockito.times(1)).eliminar(id);
    }

    @Test
    @DisplayName("Deberia lanzar una excepción por cliente no existente")
    void deberiaLanzarExcepcionPorClienteNoRegistrado() {
        Long id = 10L;
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCliente.tieneSolicitudesIngresadas(Mockito.anyLong())).thenReturn(false);
        try {
            servicioEliminarCliente.ejecutar(id);
            Assertions.fail("Deberia lanzar una excepción por cliente no existente");
        } catch (ExcepcionSinDatos ex) {
            Assertions.assertEquals("El cliente no está registrado",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Deberia lanzar una excepción por solicitudes registradas")
    void deberiaLanzarExcepcionPorSolicitudesRegistradas() {
        Long id = 10L;
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCliente.tieneSolicitudesIngresadas(Mockito.anyLong())).thenReturn(true);
        try {
            servicioEliminarCliente.ejecutar(id);
            Assertions.fail("Deberia lanzar una excepción por solicitudes registradas");
        } catch (ExcepcionDuplicidad ex) {
            Assertions.assertEquals("El cliente tiene solicitudes de crédito registradas",ex.getMessage());
        }
    }
}