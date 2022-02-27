package com.ceiba.credito.comando.manejador;

import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.servicio.ServicioConsultarCliente;
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
    private ServicioConsultarCliente servicioConsultarCliente;
    private ManejadorCrearCredito manejadorCrearCredito;

    @BeforeEach
    void inicializar() {
        fabricaCredito = Mockito.mock(FabricaCredito.class);
        servicioCrearCredito = Mockito.mock(ServicioCrearCredito.class);
        servicioConsultarCliente = Mockito.mock(ServicioConsultarCliente.class);
        manejadorCrearCredito = new ManejadorCrearCredito(fabricaCredito, servicioCrearCredito, servicioConsultarCliente);
    }

    @Test
    @DisplayName("Deberia lanzar el servicio para crear un crédito")
    void deberiaEjecutarServicioCrearCredito() {
        FabricaCredito fabrica = new FabricaCredito();
        ComandoCredito comandoCredito = aComandoCredito().build();
        DtoCliente dtoCliente = new DtoCliente(15L,"C","01012");
        Credito credito =  fabrica.crear(comandoCredito);
        Mockito.when(fabricaCredito.crear(comandoCredito)).thenReturn(credito);
        Mockito.when(servicioConsultarCliente.ejecutar(Mockito.anyString(),Mockito.anyString())).thenReturn(dtoCliente);
        Mockito.when(servicioCrearCredito.ejecutar(credito)).thenReturn(10L);
        manejadorCrearCredito.ejecutar(comandoCredito);
        Mockito.verify(servicioCrearCredito,Mockito.times(1)).ejecutar(credito);
    }
}