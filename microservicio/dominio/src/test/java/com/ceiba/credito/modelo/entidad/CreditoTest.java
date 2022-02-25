package com.ceiba.credito.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;

import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {

    String tipoIdentificacion;
    String numeroIdentificacion;
    Double ingresoNormal;
    Double egresoNormal;
    Double ingresoNegativo;
    Double egresoSuperior;

    @BeforeEach
    public void inicializar() {
        ingresoNormal = 1500.00;
        ingresoNegativo = -1500.00;
        egresoNormal = 950.00;
        egresoSuperior = 2500.00;
        tipoIdentificacion ="C";
        numeroIdentificacion = "02012";
    }

    @Test
    @DisplayName("Deberia crear credito correctamente")
    void deberiaCrearCreditoCorrectamente() {
        Credito credito = aCredito()
                .conTipoIdentificacion(tipoIdentificacion)
                .conNumeroIdentificacion(numeroIdentificacion)
                .conIngresoMensual(ingresoNormal)
                .conEgresoMensual(egresoNormal)
                .conPlazo(6)
                .conTasaCambio(3491.12).build();
        assertEquals("C", credito.getTipoIdentificacion());
        assertEquals("02012", credito.getNumeroIdentificacion());
        assertEquals(1500.00, credito.getIngresoMensual());
        assertEquals(950.00, credito.getEgresoMensual());
        assertEquals(6, credito.getPlazo());
        assertEquals(3491.12, credito.getTasaCambio());
    }


    @Test
    @DisplayName("Debería lanzar excepción por tipo identificación nula")
    void deberiaLanzarExcepcionPorTipoIdentificacionNula() {
        try {
            Credito credito = aCredito()
                    .conTipoIdentificacion(null).build();
            fail("Debería lanzar excepción por tipo identificación nula");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de tipo de identificación es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por número identificación nula")
    void deberiaLanzarExcepcionPorNumeroIdentificacionNula() {
        try {
            Credito credito = aCredito()
                    .conNumeroIdentificacion(null).build();
            fail("Debería lanzar excepción por número identificación nula");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de número de identificación es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de ingresos negativo")
    void deberiaLanzarExcepcionPorValorDeIngresoNulo() {
        try {
            Credito credito = aCredito()
                    .conIngresoMensual(-1.00).build();
            fail("Debería lanzar excepción por valor de ingresos nulo");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El campo de valor de ingresos mensuales es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de egresos negativo")
    void deberiaLanzarExcepcionPorValorDeEgresoNulo() {
        try {
            Credito credito = aCredito()
                    .conEgresoMensual(-1.00).build();
            fail("Debería lanzar excepción por valor de egresos nulo");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El campo de valor de egresos mensuales es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por egreso mayor que ingreso")
    void deberiaLanzarExcepcionPorEgresoMayorQueIngreso() {
        try {
            Credito credito = aCredito()
                    .conIngresoMensual(ingresoNormal)
                    .conEgresoMensual(egresoSuperior).build();
            fail("Debería lanzar excepción por egreso mayor que ingreso");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de egeresos  mensuales debe ser menor que los ingresos",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo nulo")
    void deberiaLanzarExcepcionPorPlazoNulo() {
        try {
            Credito credito = aCredito()
                    .conPlazo(null).build();
            fail("Debería lanzar excepción por plazo nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor de plazo es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo invalido")
    void deberiaLanzarExcepcionPorPlazoInvalido() {
        try {
            Credito credito = aCredito()
                    .conPlazo(5).build();
            fail("Debería lanzar excepción por plazo invalido");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor permitido para el plazo es 3, 6 o 12 meses",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por tasa de cambio nula")
    void deberiaLanzarExcepcionPorTasaCambioNula() {
        try {
            Credito credito = aCredito()
                    .conTasaCambio(-1.00).build();
            fail("Debería lanzar excepción por tasa de cambio nula");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El campo de tasa de cambio es obligatorio",ex.getMessage());
        }
    }

}