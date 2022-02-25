package com.ceiba.credito.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCredito {
    private Long id;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private LocalDate fechaSolicitud;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double valorPrestamo;
    private Double valorDividendo;
    private Double tasaCambio;
    private LocalDate fechaPrimeraCuota;
    private String estado;
}
