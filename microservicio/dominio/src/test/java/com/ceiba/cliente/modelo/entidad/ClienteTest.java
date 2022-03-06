package com.ceiba.cliente.modelo.entidad;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import  static com.ceiba.cliente.modelo.entidad.ClienteTestDataBuilder.aCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ClienteTest {

    private Cliente cliente;

    @Test
    @DisplayName("Deberia crear un cliente correctamente")
    void deberiaCrearUnClienteSatisfactoriamente() {
        cliente = aCliente().conTipoIdentificacion(EnumTipoIdentificacion.CEDULA).conNumeroIdentificacion("010120018").build();
        assertEquals("C",cliente.getTipoIdentificacion().getCodigo());
        assertEquals("010120018",cliente.getNumeroIdentificacion());
    }

    @Test
    @DisplayName("Deberia crear un cliente y asignar el codigo")
    void deberiaCrearUnClienteSatisfactoriamenteYAsignarCodigo() {
        cliente = aCliente().conTipoIdentificacion(EnumTipoIdentificacion.CEDULA).conNumeroIdentificacion("010120018").build();
        cliente.setId(10l);
        assertEquals(10,cliente.getId());
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