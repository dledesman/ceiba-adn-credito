package com.ceiba.dinero.modelo.enumeracion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumMonedaTest {

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverCodigoDeEnumeracion() {
        EnumMoneda moneda = EnumMoneda.EURO;
        String codigo = moneda.getCodigo();
        assertEquals("EUR",codigo);
    }


    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverUnaEnumerionDeUnCodigo() {
        for(EnumMoneda moneda: EnumMoneda.values()) {
            EnumMoneda monedaBuscada = EnumMoneda.EURO.getMoneda(moneda.getCodigo());
            assertEquals(moneda,monedaBuscada);
        }
    }

}