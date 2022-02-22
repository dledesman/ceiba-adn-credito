package com.ceiba.identificacion.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static com.ceiba.identificacion.modelo.entidad.IdentificacionTestDataBuilder.anIdentificacion;

public class IdentificacionTest {

    @Test
    @DisplayName("Debería crear la identificación correctamente")
    public void deberiaCrearLaIdentificacionCorrectamente() {
        Identificacion identificacion = anIdentificacion()
                .conTipoIdentificacion("C")
                .conNumeroIdentificacion("02012").build();
        assertEquals("C",identificacion.getTipoIdentificacion());
        assertEquals("02012",identificacion.getNumeroIdentificacion());
    }

    @Test
    @DisplayName("Deberia lanzar excepcion por tipo de identificacion nulo")
    public void deberiaLanzarExcepcionPorTipoIdenDetificacionNulo() {
        try {
            Identificacion identificacion = anIdentificacion()
                    .conTipoIdentificacion(null)
                    .conNumeroIdentificacion("02012").build();
            fail("Deberia lanzar excepcion por tipo de identificacion nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El tipo de identificación es un valor obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Deberia lanzar excepcion por número de identificacion nulo")
    public void deberiaLanzarExcepcionPorNumeroDeIdentificacionNulo() {
        try {
            Identificacion identificacion = anIdentificacion()
                    .conTipoIdentificacion("C")
                    .conNumeroIdentificacion(null).build();
            fail("Deberia lanzar excepcion por número de identificacion nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El número de identificación es un valor obligatorio",ex.getMessage());
        }
    }
}