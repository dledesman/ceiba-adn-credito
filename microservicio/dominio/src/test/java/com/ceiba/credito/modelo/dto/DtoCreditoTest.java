package com.ceiba.credito.modelo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DtoCreditoTest {

    private DtoCredito dtoCredito;

    private long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private LocalDate fechaSolicitud;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double tasaCambio;
    private Double valorPrestamo;
    private Double valorDividendo;
    private LocalDate fechaPrimeraCuota;
    private String estado;

    @BeforeEach
    void inicializar() {
        id=10L;
        tipoIdentificacion="C";
        numeroIdentificacion="02012";
        fechaSolicitud=LocalDate.now();
        ingresoMensual=1500.00;
        egresoMensual=950.00;
        codigoMoneda="USD";
        plazo=6;
        tasaCambio=3945.12;
        valorPrestamo=4512.12;
        valorDividendo=450.12;
        fechaPrimeraCuota=LocalDate.now();
        estado="I";
    }

    @Test
    @DisplayName("Debería crear objeto DtoCredito correctamente")
    void deberiaCrearObjetoCorrectamente() {
        dtoCredito = new DtoCredito(id, tipoIdentificacion, numeroIdentificacion, fechaSolicitud, ingresoMensual, egresoMensual,
                codigoMoneda, tasaCambio, plazo, valorPrestamo, valorDividendo, fechaPrimeraCuota, estado);
        assertEquals(id,dtoCredito.getId());
        assertEquals(tipoIdentificacion,dtoCredito.getTipoIdentificacion());
        assertEquals(numeroIdentificacion,dtoCredito.getNumeroIdentificacion());
        assertEquals(fechaSolicitud,dtoCredito.getFechaSolicitud());
        assertEquals(ingresoMensual,dtoCredito.getIngresoMensual());
        assertEquals(egresoMensual,dtoCredito.getEgresoMensual());
        assertEquals(codigoMoneda,dtoCredito.getCodigoMoneda());
        assertEquals(plazo,dtoCredito.getPlazo());
        assertEquals(tasaCambio,dtoCredito.getTasaCambio());
        assertEquals(valorPrestamo,dtoCredito.getValorPrestamo());
        assertEquals(valorDividendo,dtoCredito.getValorDividendo());
        assertEquals(estado,dtoCredito.getEstado());
    }

}