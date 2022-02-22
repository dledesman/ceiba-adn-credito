package com.ceiba.credito.modelo.entidad;

import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.identificacion.modelo.entidad.Identificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.ceiba.identificacion.modelo.entidad.IdentificacionTestDataBuilder.anIdentificacion;
import static com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder.aDinero;
import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;

import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {

    Identificacion identificacion;
    Dinero ingresoNormal;
    Dinero egresoNormal;
    Dinero ingresoNegativo;
    Dinero egresoSuperior;

    @BeforeEach
    public void inicializar() {
        ingresoNormal = aDinero()
                .conCodigo("USD")
                .conValor(1500.00)
                .conTasaCambio(3981.24).build();
        ingresoNegativo = aDinero()
                .conCodigo("USD")
                .conValor(-1500.00)
                .conTasaCambio(3981.24).build();
        egresoNormal = aDinero()
                .conCodigo("USD")
                .conValor(950.00)
                .conTasaCambio(3981.24).build();
        egresoSuperior = aDinero()
                .conCodigo("USD")
                .conValor(2500.00)
                .conTasaCambio(3981.245).build();
        identificacion = anIdentificacion()
                .conTipoIdentificacion("C")
                .conNumeroIdentificacion("02012").build();
    }

    @Test
    @DisplayName("Deberia crear credito correctamente")
    public void deberiaCrearCreditoCorrectamente() {
        Credito credito = aCredito()
                .conIdentificacion(identificacion)
                .conIngresoMensual(ingresoNormal)
                .conEgresoMensual(egresoNormal)
                .conPlazo(6).build();
        assertEquals("02012", credito.getIdentificacion().getNumeroIdentificacion());
        assertEquals(1500.00, credito.getIngresoMensual().getValor());
        assertEquals(950.00, credito.getEgresoMensual().getValor());
        assertEquals(6, credito.getPlazo());
    }

    @Test
    @DisplayName("Debería lanzar excepción por identificación nula")
    public void deberiaLanzarExcepcionPorIdentificacionNula() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(null)
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(egresoNormal)
                    .conPlazo(6).build();
            fail("Debería lanzar excepción por identificación nula");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de identificación es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de egresos nulo")
    public void deberiaLanzarExcepcionPorValorDeEgresoNulo() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(null)
                    .conPlazo(6).build();
            fail("Debería lanzar excepción por valor de egresos nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor de egresos mensuales es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de ingresos nulo")
    public void deberiaLanzarExcepcionPorValorDeIngresoNulo() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(null)
                    .conEgresoMensual(egresoNormal)
                    .conPlazo(6).build();
            fail("Debería lanzar excepción por valor de ingresos nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor de ingresos mensuales es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo ingreso negativo")
    public void deberiaLanzarExcepcionPorIngresoNegativo() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(ingresoNegativo)
                    .conEgresoMensual(egresoNormal)
                    .conPlazo(6).build();
            fail("Debería lanzar excepción por plazo ingreso negativo");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de ingresos  mensuales debe ser mayor a cero",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por egreso mayor que ingreso")
    public void deberiaLanzarExcepcionPorEgresoMayorQueIngreso() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(egresoSuperior)
                    .conPlazo(6).build();
            fail("Debería lanzar excepción por egreso mayor que ingreso");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de egeresos  mensuales debe ser menor que los ingresos",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo nulo")
    public void deberiaLanzarExcepcionPorPlazoNulo() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(egresoNormal)
                    .conPlazo(null).build();
            fail("Debería lanzar excepción por plazo nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor de plazo es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo invalido")
    public void deberiaLanzarExcepcionPorPlazoInvalido() {
        try {
            Credito credito = aCredito()
                    .conIdentificacion(identificacion)
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(egresoNormal)
                    .conPlazo(5).build();
            fail("Debería lanzar excepción por plazo invalido");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor permitido para el plazo es 3, 6 o 12 meses",ex.getMessage());
        }
    }

}