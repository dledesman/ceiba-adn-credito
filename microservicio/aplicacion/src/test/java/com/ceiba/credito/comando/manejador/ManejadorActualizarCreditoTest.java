package com.ceiba.credito.comando.manejador;


import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.comando.fabrica.FabricaCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.servicio.ServicioActualizarCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static com.ceiba.credito.comando.ComandoCreditoTestDataBuilder.aComandoCredito;

class ManejadorActualizarCreditoTest {

    private FabricaCredito fabricaCredito;
    private ServicioActualizarCredito servicioActualizarCredito;
    private ManejadorActualizarCredito manejadorActualizarCredito;

    @BeforeEach
    void inicializar() {
        fabricaCredito = Mockito.mock(FabricaCredito.class);
        servicioActualizarCredito = Mockito.mock(ServicioActualizarCredito.class);
        manejadorActualizarCredito = new ManejadorActualizarCredito(fabricaCredito, servicioActualizarCredito);
    }

    @Test
    @DisplayName("Debería lanzar el servicio de actualización de crédito")
    void deberiaEjecutarServicioActualizacionCredito() {
        ComandoCredito comandoCredito = aComandoCredito().build();
        Credito credito = fabricaCredito.crear(comandoCredito);
        manejadorActualizarCredito.ejecutar(comandoCredito);
        Mockito.verify(servicioActualizarCredito,Mockito.times(1))
            .ejecutar(credito);
    }
}