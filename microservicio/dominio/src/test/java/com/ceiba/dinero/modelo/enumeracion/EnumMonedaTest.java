package com.ceiba.dinero.modelo.enumeracion;

import com.ceiba.credito.modelo.enumeracion.EnumEstado;
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
        String codigo = "USD";
        EnumMoneda moneda = EnumMoneda.EURO.getMoneda(codigo);
        assertEquals(EnumMoneda.DOLAR.getMoneda(codigo),moneda);
    }

}