package com.ceiba.credito.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCredito {
    private Long id;
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
