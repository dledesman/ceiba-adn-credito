package com.ceiba.credito.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCredito {
    private Double valorPrestamo;
    private Double tasaCambio;
    private LocalDate fechaPrimeraCuota;
    private Double valorDividendo;
    private String estado;
    private String tipoIdentificacion;
    private long id;
    private LocalDate fechaSolicitud;
    private String numeroIdentificacion;
    private Double egresoMensual;
    private Double ingresoMensual;
    private Integer plazo;
    private String codigoMoneda;
}
