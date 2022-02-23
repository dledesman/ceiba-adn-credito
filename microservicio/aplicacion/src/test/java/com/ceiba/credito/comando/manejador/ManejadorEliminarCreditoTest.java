package com.ceiba.credito.comando.manejador;

import com.ceiba.credito.servicio.ServicioEliminarCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class ManejadorEliminarCreditoTest {

    private ServicioEliminarCredito servicioEliminarCredito;
    private ManejadorEliminarCredito manejadorEliminarCredito;

    @BeforeEach
    void inicializar() {
        servicioEliminarCredito = Mockito.mock(ServicioEliminarCredito.class);
        manejadorEliminarCredito = new ManejadorEliminarCredito(servicioEliminarCredito);
    }

    @Test
    @DisplayName("Debería ejecutar el servicio para eliminar un credito")
    void debeEjkecutarServicioParaEliminarCredito() {
        manejadorEliminarCredito.ejecutar(10L);
        Mockito.verify(servicioEliminarCredito,Mockito.times(1)).ejecutar(10L);
    }
}