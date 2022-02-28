package com.ceiba.credito.modelo.enumeracion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumEstadoTest {

    @Test
    @DisplayName("Debería devolver el código correspondiente a la enumeración enviada")
    void deberiaDevolverCodigoDeEnumeracion() {
        EnumEstado estado = EnumEstado.INGRESADO;
        String codigo = estado.getCodigo();
        assertEquals("I",codigo);
    }

}