package com.ceiba.credito.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCredito {
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
}
