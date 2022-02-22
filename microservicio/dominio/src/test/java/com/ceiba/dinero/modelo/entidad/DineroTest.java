package com.ceiba.dinero.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder.aDinero;
class DineroTest {

    @Test
    @DisplayName("Debeería crear dinero correctamenmte")
    void deberiaCrearDineroCorrectamente() {
        Dinero dinero = aDinero().conCodigo("USD")
                .conValor(1500.00)
                .conTasaCambio(3980.12).build();
        assertEquals("USD",dinero.getCodigo());
        assertEquals(1500.00,dinero.getValor());
        assertEquals(3980.12,dinero.getTasaCambio());
    }

    @Test
    @DisplayName("Debería lanzar excepción por codigo nulo")
    public void deberiaLanzarExcepcionPorCodigoNulo(){
        try {
            Dinero dinero = aDinero().conCodigo(null)
                    .conValor(1500.00)
                    .conTasaCambio(3980.12).build();
            fail("Debería lanzar excepción por codigo nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El código de moneda es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor nulo")
    public void deberiaLanzarExcepcionPorValorNulo(){
        try {
            Dinero dinero = aDinero().conCodigo("USD")
                    .conValor(null)
                    .conTasaCambio(3980.12).build();
            fail("Debería lanzar excepción por valor nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por tasa de cambio nulo")
    public void deberiaLanzarExcepcionPorTasaCambioNulo(){
        try {
            Dinero dinero = aDinero().conCodigo("USD")
                    .conValor(1500.00)
                    .conTasaCambio(null).build();
            fail("Debería lanzar excepción por tasa de cambio nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("La tasa de cambio es un valor obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por tasa de cambio negativa")
    public void deberiaLanzarExcepcionPorTasaCambioNegativa(){
        try {
            Dinero dinero = aDinero().conCodigo("USD")
                    .conValor(1500.00)
                    .conTasaCambio(-142.54).build();
            fail("Debería lanzar excepción por tasa de cambio negativa");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("La tasa de cambio debe ser mayor a cero",ex.getMessage());
        }
    }

}