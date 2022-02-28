package com.ceiba.cliente.modelo.entidad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoClienteTest {

    DtoCliente dtoCliente;
    @Test
    @DisplayName("Debería crear un objeto ComandoCliente conrrectamente")
    void deberiaCrearObjetoCorrectamente() {
        Long id = 10L;
        String tipoIdentificacion = "C";
        String numeroIdentificacion = "02012";
        dtoCliente = new DtoCliente(id,tipoIdentificacion,numeroIdentificacion);
        assertEquals(id,dtoCliente.getId());
        assertEquals(id,dtoCliente.getId());
        assertEquals(tipoIdentificacion,dtoCliente.getTipoIdentificacion());
        assertEquals(numeroIdentificacion,dtoCliente.getNumeroIdentificacion());
    }

}