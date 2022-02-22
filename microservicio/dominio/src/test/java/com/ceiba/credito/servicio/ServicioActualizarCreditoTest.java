package com.ceiba.credito.servicio;

import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;
import static org.junit.jupiter.api.Assertions.*;

class ServicioActualizarCreditoTest {

    RepositorioCredito repositorioCredito;
    ServicioActualizarCredito servicioActualizarCredito;

    @BeforeEach
    public void inicializar(){
        repositorioCredito = Mockito.mock(RepositorioCredito.class);
        servicioActualizarCredito = new ServicioActualizarCredito(repositorioCredito);
    }
    @Test
    @DisplayName("Debería actualizar una solicitud de crédito correctamente")
    void deberiaActualizarSolicitudCorrectamente() {
        Credito credito = aCredito().build();
        Mockito.when(repositorioCredito.existePorId(credito.getCodigo())).thenReturn(true);
        servicioActualizarCredito.ejecutar(credito);
        Mockito.verify(repositorioCredito,Mockito.times(1)).actualizar(credito);
    }

    @Test
    @DisplayName("Deberia lanzar excepción por objeto crédito no creado")
    public void deberiaLanzarExcepcionPorObjetoCreditoNoCreado() {
        Credito credito = null;
        Mockito.when(repositorioCredito.existePorId(Mockito.anyLong())).thenReturn(true);
        try {
            servicioActualizarCredito.ejecutar(credito);
            fail("Deberia lanzar excepción por objeto crédito no creado");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("Los atributos del crédito no han sido enviados",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Deberia lanzar excepción por solicitud de crédito no existente")
    public void deberiaLanzarExcepcionPorSolicitudDeCreditoNoExistente() {
        Credito credito =  aCredito().build();
        Mockito.when(repositorioCredito.existePorId(Mockito.anyLong())).thenReturn(false);
        try {
            servicioActualizarCredito.ejecutar(credito);
            fail("Deberia lanzar excepción por solicitud de crédito no existente");
        } catch (ExcepcionSinDatos ex) {
            assertEquals("La solicitud de crédito no se encuentra registrada",ex.getMessage());
        }
    }
}