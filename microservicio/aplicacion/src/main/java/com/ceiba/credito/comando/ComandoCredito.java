package com.ceiba.credito.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCredito {
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double tasaCambio;
}
