package com.ceiba.credito.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCredito {
    private long id;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String monedaTransaccion;
    private Double ingresoMensual;
    private Double egresoMensual;
    private Integer plazo;
    private Double valorPrestamo;
    private Double valorDividendo;
    private Date fechaPrimeraCuota;
}
