package com.ceiba.credito.modelo.enumeracion;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumPlazoTest {

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverCodigoDeEnumeracion() {
        EnumPlazo enumPlazo = EnumPlazo.SEIS;
        Integer codigo = enumPlazo.getNumero();
        assertEquals(6,codigo);
    }

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverUnaEnumerionDeUnCodigo() {
        Integer codigo = 12;
        EnumPlazo plazo = EnumPlazo.SEIS.getPlazo(codigo);
        assertEquals(EnumPlazo.DOCE,plazo);
    }

}