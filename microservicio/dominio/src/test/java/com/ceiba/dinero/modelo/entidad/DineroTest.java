package com.ceiba.dinero.modelo.entidad;

import com.ceiba.dinero.modelo.enumeracion.EnumMoneda;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder.aDinero;

class DineroTest {

    @Test
    @DisplayName("Debería crear objeto dinero correctamente")
    void deberiaCrearDineroCorrectamente() {
        Dinero dinero = aDinero()
                .conMoneda(EnumMoneda.EURO)
                .conValor(1500.00)
                .conTasaCambio(3975.12).build();
        Assertions.assertEquals(EnumMoneda.EURO,dinero.getMoneda());
        Assertions.assertEquals(1500.00,dinero.getValor());
        Assertions.assertEquals(3975.12,dinero.getTasaCambio());
    }

    @Test
    @DisplayName("Debería lanzar excepción por moneda nula")
    void deberiaLanzarExcepcionPorMonedaNula() {
        try {
            Dinero dinero = aDinero()
                    .conMoneda(null)
                    .conValor(1500.00)
                    .conTasaCambio(3975.12).build();
            Assertions.fail("Debería lanzar excepción por moneda nula");
        } catch (ExcepcionValorObligatorio ex) {
            Assertions.assertEquals("El código de moneda es un campo obligatorio",ex.getMessage());
        }
    }
}