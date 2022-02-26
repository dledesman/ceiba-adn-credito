package com.ceiba.dinero.modelo.entidad;

import com.ceiba.dinero.modelo.enumeracion.EnumMoneda;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Dinero {

    private static final String CODIGO_DE_MONEDA_ES_OBLIGATORIO = "El código de moneda es un campo obligatorio";
    private final EnumMoneda moneda;
    private Double valor;
    private Double tasaCambio;

    public Dinero(EnumMoneda moneda, Double valor, Double tasaCambio) {
        validarObligatorio(moneda,CODIGO_DE_MONEDA_ES_OBLIGATORIO);
        this.moneda = moneda;
        this.valor = valor;
        this.tasaCambio = tasaCambio;
    }

}
