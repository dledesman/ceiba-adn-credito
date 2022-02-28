package com.ceiba.cliente.comando;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoClienteTest {

    private ComandoCliente comandoCliente;

    @Test
    @DisplayName("Debería crear un objeto ComandoCliente conrrectamente")
    void deberiaCrearObjetoCorrectamente() {
        Long id = 10L;
        String tipoIdentificacion = "C";
        String numeroIdentificacion = "02012";
        comandoCliente = new ComandoCliente(id,tipoIdentificacion,numeroIdentificacion);
        assertEquals(id,comandoCliente.getId());
        assertEquals(id,comandoCliente.getId());
        assertEquals(tipoIdentificacion,comandoCliente.getTipoIdentificacion());
        assertEquals(numeroIdentificacion,comandoCliente.getNumeroIdentificacion());
    }

}