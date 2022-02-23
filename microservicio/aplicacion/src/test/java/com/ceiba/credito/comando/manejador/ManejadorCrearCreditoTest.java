package com.ceiba.credito.comando.manejador;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.comando.fabrica.FabricaCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.servicio.ServicioCrearCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static com.ceiba.credito.comando.ComandoCreditoTestDataBuilder.aComandoCredito;

class ManejadorCrearCreditoTest {

    private FabricaCredito fabricaCredito;
    private ServicioCrearCredito servicioCrearCredito;
    private ManejadorCrearCredito manejadorCrearCredito;

    @BeforeEach
    void inicializar() {
        fabricaCredito = Mockito.mock(FabricaCredito.class);
        servicioCrearCredito = Mockito.mock(ServicioCrearCredito.class);
        manejadorCrearCredito = new ManejadorCrearCredito(fabricaCredito, servicioCrearCredito);
    }

    @Test
    @DisplayName("Deberia lanzar el servicio para crear un crédito")
    void deberiaEjecutarServicioCrearCredito() {
        ComandoCredito comandoCredito = aComandoCredito().build();
        Credito credito = fabricaCredito.crear(comandoCredito);
        Mockito.when(fabricaCredito.crear(comandoCredito)).thenReturn(credito);
        Mockito.when(servicioCrearCredito.ejecutar(credito)).thenReturn(10L);
        manejadorCrearCredito.ejecutar(comandoCredito);
        Mockito.verify(servicioCrearCredito,Mockito.times(1)).ejecutar(credito);
    }
}