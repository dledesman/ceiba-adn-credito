package com.ceiba.cliente.modelo.enumeracion;

import com.ceiba.dinero.modelo.enumeracion.EnumMoneda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumTipoIdentificacionTest {

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverCodigoDeEnumeracion() {
        EnumTipoIdentificacion tipoIdentificacion = EnumTipoIdentificacion.CEDULA;
        String codigo = tipoIdentificacion.getCodigo();
        assertEquals("C",codigo);
    }

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverUnaEnumerionDeUnCodigo() {
        for(EnumMoneda moneda: EnumMoneda.values()) {
            EnumMoneda monedaBuscada = EnumMoneda.DOLAR.getMoneda(moneda.getCodigo());
            assertEquals(moneda,monedaBuscada);
        }
    }

}