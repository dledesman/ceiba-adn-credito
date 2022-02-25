package com.ceiba.credito.servicio;

import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;

class ServicioCrearCreditoTest {

    RepositorioCredito repositorioCredito;
    ServicioCrearCredito servicioCrearCredito;

    @BeforeEach
    public void inicializar() {
        repositorioCredito = Mockito.mock(RepositorioCredito.class);
        servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
    }

    @Test
    @DisplayName("Deberia crear el crédito correctamente")
    void deberiaCrearCreditoCorrectamente() {
        Credito credito = aCredito().build();
        Mockito.when(repositorioCredito.existe(credito.getNumeroIdentificacion())).thenReturn(false);
        Mockito.when(repositorioCredito.crear(credito)).thenReturn(10L);
        Assertions.assertEquals(10L,servicioCrearCredito.ejecutar(credito));
    }

    @Test
    @DisplayName("Deberia lanzar excepción por objeto crédito no creado")
    void deberiaLanzarExcepcionPorObjetoCreditoNoCreado() {
        Credito credito= null;
        Mockito.when(repositorioCredito.crear(credito)).thenReturn(10L);
        try {
            servicioCrearCredito.ejecutar(credito);
            Assertions.fail("Deberia lanzar excepción por objeto crédito no creado");
        } catch (ExcepcionValorObligatorio ex) {
            Assertions.assertEquals("Los atributos del crédito no han sido enviados",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Deberia lanzar excepción por solicitud ya ingresada")
    void deberiaLanzarExcepcionPorSolicitudYaIngresada() {
        Credito credito = aCredito().build();
        Mockito.when(repositorioCredito.existe(credito.getNumeroIdentificacion())).thenReturn(true);
        Mockito.when(repositorioCredito.crear(credito)).thenReturn(10L);
        try {
            servicioCrearCredito.ejecutar(credito);
            Assertions.fail("Deberia lanzar excepción por solicitud ya ingresada");
        } catch (ExcepcionDuplicidad ex) {
            Assertions.assertEquals("El socio ya registra en solicitu de crédito en trámite",ex.getMessage());
        }
    }

}