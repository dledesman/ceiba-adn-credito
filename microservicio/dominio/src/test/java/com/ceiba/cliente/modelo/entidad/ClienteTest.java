package com.ceiba.cliente.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.cliente.modelo.entidad.DtoClienteTestDataBuilder.aDtoCliente;
import static com.ceiba.cliente.modelo.entidad.ClienteTestDataBuilder.aCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ClienteTest {

    private DtoCliente dtoCliente;

    @Test
    @DisplayName("Deberia crear un cliente correctamente")
    void deberiaCrearUnClienteSatisfactoriamente() {
        dtoCliente = aDtoCliente().conTipoIdentificacion("C").conNumeroIdentificacion("010120018").build();
        assertEquals("C",dtoCliente.getTipoIdentificacion());
        assertEquals("010120018",dtoCliente.getNumeroIdentificacion());
    }

    @Test
    @DisplayName("Deberia lanzar una excepción por tipo de identificación nulo")
    void deberiaLanzarExcepcionPorTipoIdentificacionNulo() {
        try {
            Cliente cliente = aCliente().conTipoIdentificacion(null)
                    .conNumeroIdentificacion("010120018").build();
            fail("Deberia lanzar una excepción por tipo de identificación nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El tipo de identificación es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Deberia lanzar una excepción por el numero de identificación nulo")
    void deberiaLanzarExcepcionPorNumeroDeIdentificacionNulo() {
        try {
            Cliente cliente = aCliente().conCodigo(10L).conNumeroIdentificacion(null).build();
            fail("Deberia lanzar una excepción por el numero de identificación nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El número de identificación es obligatorio",ex.getMessage());
        }
    }

}