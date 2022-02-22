package com.ceiba.credito.servicio;

import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioEliminarCreditoTest {

    private RepositorioCredito repositorioCredito;
    private ServicioEliminarCredito servicioEliminarCredito;

    @BeforeEach
    public void inicializar() {
        repositorioCredito = Mockito.mock(RepositorioCredito.class);
        servicioEliminarCredito = new ServicioEliminarCredito(repositorioCredito);
    }

    @Test
    @DisplayName("Debería eliminar la solicitud de crédito correctamente")
    void deberiaEliminarSolicitudCreditoCorrectamente() {
        Mockito.when(repositorioCredito.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarCredito.ejecutar(10L);
        Mockito.verify(repositorioCredito,Mockito.times(1)).eliminar(10L);
    }

    @Test
    @DisplayName("Debería lanzar excpeción por solicitud de crédito no existente")
    public void deberiaLanzarExcepcionPorSolicitodNoExistente() {
        Mockito.when(repositorioCredito.existePorId(Mockito.anyLong())).thenReturn(false);
        try {
            servicioEliminarCredito.ejecutar(10L);
            fail("Debería lanzar excpeción por solicitud de crédito no existente");
        } catch (ExcepcionSinDatos ex) {
            assertEquals("La solicitud de crédito no se encuentra registrada",ex.getMessage());
        }
    }
}