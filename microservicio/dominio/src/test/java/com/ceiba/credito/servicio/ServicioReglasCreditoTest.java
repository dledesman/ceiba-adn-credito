package com.ceiba.credito.servicio;

import com.ceiba.credito.modelo.entidad.Credito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static com.ceiba.credito.modelo.entidad.CreditoTestDataBuilder.aCredito;

class ServicioReglasCreditoTest {

    private Credito credito;
    private final Double tasaInteres = 8.50/100;
    private final Double factorDeInteres = tasaInteres / 12;
    private final Double factorDeTiempo = 1 / ( 1+ factorDeInteres);
    private ServicioReglasCredito servicioReglasCredito;

    @BeforeEach
    void inicializar() {
        LocalDate fechaSolicitud = LocalDate.of(2022,03,24);
        credito = aCredito().conIngresoMensual(2300.00)
                .conEgresoMensual(2000.00).conPlazo(12).conFechaSolicitud(fechaSolicitud).build();
        servicioReglasCredito = new ServicioReglasCredito(credito);
    }

    @Test
    @DisplayName("Debería calcular el valor del crédito y la fecha de vencimiento de la primera cuota")
    void calcularValorPrestamo() {
        LocalDate fechaEsperada = LocalDate.of(2022,04,29);
        servicioReglasCredito.calcularValorPrestamo();
        assertEquals(3440.0,credito.getValorPrestamo() );
        assertEquals(fechaEsperada,credito.getFechaPrimeraCuota() );
    }
}