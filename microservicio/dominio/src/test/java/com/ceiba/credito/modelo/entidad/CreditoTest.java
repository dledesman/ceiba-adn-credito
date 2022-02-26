package com.ceiba.credito.modelo.entidad;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.credito.modelo.enumeracion.EnumPlazo;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;
import static com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder.aDinero;
import static com.ceiba.cliente.modelo.entidad.ClienteTestDataBuilder.aCliente;
import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {

    String tipoIdentificacion;
    String numeroIdentificacion;
    Double ingresoNormal;
    Double egresoNormal;
    Double ingresoNegativo;
    Double egresoSuperior;

    @BeforeEach
    public void inicializar() {
        ingresoNormal = 1500.00;
        ingresoNegativo = -1500.00;
        egresoNormal = 950.00;
        egresoSuperior = 2500.00;
        tipoIdentificacion ="C";
        numeroIdentificacion = "02012";
    }

    @Test
    @DisplayName("Deberia crear credito correctamente")
    void deberiaCrearCreditoCorrectamente() {
        Credito credito = aCredito()
                .conCliente(aCliente().conTipoIdentificacion(EnumTipoIdentificacion.CEDULA).conNumeroIdentificacion("02012").build())
                .conIngresoMensual(aDinero().conValor(ingresoNormal).conTasaCambio(3491.12).build())
                .conEgresoMensual(aDinero().conValor(egresoNormal).build())
                .conPlazo(EnumPlazo.SEIS).build();
        assertEquals("C", credito.getCliente().getTipoIdentificacion().getCodigo());
        assertEquals("02012", credito.getCliente().getNumeroIdentificacion());
        assertEquals(1500.00, credito.getIngresoMensual().getValor());
        assertEquals(950.00, credito.getEgresoMensual().getValor());
        assertEquals(6, credito.getPlazo().getNumero());
        assertEquals(3491.12, credito.getIngresoMensual().getTasaCambio());
    }


    @Test
    @DisplayName("Debería lanzar excepción por cliente nulo")
    void deberiaLanzarExcepcionPorNumeroIdentificacionNula() {
        try {
            Credito credito = aCredito()
                    .conCliente(null).build();
            fail("Debería lanzar excepción por cliente nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El cliente es obligatorio para registro de la solicitud",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de ingresos negativo")
    void deberiaLanzarExcepcionPorValorDeIngresoNulo() {
        try {
            Credito credito = aCredito()
                    .conIngresoMensual(aDinero().conValor(-1.00).build()).build();
            fail("Debería lanzar excepción por valor de ingresos nulo");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de ingresos  mensuales debe ser mayor a cero",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por valor de egresos negativo")
    void deberiaLanzarExcepcionPorValorDeEgresoNulo() {
        try {
            Credito credito = aCredito()
                    .conIngresoMensual(aDinero().conValor(1500.00).build())
                    .conEgresoMensual(aDinero().conValor(-1.00).build()).build();
            fail("Debería lanzar excepción por valor de egresos nulo");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de egresos  mensuales debe ser mayor a cero",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por egreso mayor que ingreso")
    void deberiaLanzarExcepcionPorEgresoMayorQueIngreso() {
        try {
            Credito credito = aCredito()
                    .conIngresoMensual(aDinero().conValor(ingresoNormal).build())
                    .conEgresoMensual(aDinero().conValor(egresoSuperior).build()).build();
            fail("Debería lanzar excepción por egreso mayor que ingreso");
        } catch (ExcepcionValorInvalido ex) {
            assertEquals("El valor de egeresos  mensuales debe ser menor que los ingresos",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por plazo nulo")
    void deberiaLanzarExcepcionPorPlazoNulo() {
        try {
            Credito credito = aCredito()
                    .conPlazo(null).build();
            fail("Debería lanzar excepción por plazo nulo");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El campo de valor de plazo es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería lanzar excepción por tasa de cambio nula")
    void deberiaLanzarExcepcionPorTasaCambioNula() {
        try {
            Credito credito = aCredito().conIngresoMensual(aDinero().conValor(1500.00)
                    .conTasaCambio(null).build()).build();
            fail("Debería lanzar excepción por tasa de cambio nula");
        } catch (ExcepcionValorObligatorio ex) {
            assertEquals("El valor de la tasa de cambio en los ingresos es obligatorio",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Debería calcular el valor del crédito y la fecha de vencimiento de la primera cuota")
    void deberiaCalcularValorPrestamoYFechaVencimiento() {
        Credito credito = aCredito().conIngresoMensual(aDinero().conValor(2300.00)
                .conTasaCambio(3981.25).build())
                .conEgresoMensual(aDinero().conValor(2000.00).build())
                .conPlazo(EnumPlazo.DOCE)
                .conFechaSolicitud(LocalDate.of(2022,03,24)).build();
        LocalDate fechaEsperada = LocalDate.of(2022,04,29);
        assertEquals(3440.0,credito.getValorPrestamo().getValor() );
        assertEquals(fechaEsperada,credito.getFechaPrimeraCuota() );
    }



}