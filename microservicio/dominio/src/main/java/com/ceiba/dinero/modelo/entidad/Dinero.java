package com.ceiba.dinero.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Dinero {

    private static final String EL_CODIGO_DE_MONEDA_ES_OBLIGATORIO = "El código de moneda es obligatorio";
    private static final String EL_CAMPO_DE_VALOR_ES_OBLIGATORIO = "El campo de valor es obligatorio";
    private static final String LA_TASA_DE_CAMBIO_ES_OBLIGATORIO = "La tasa de cambio es un valor obligatorio";
    private static final String LA_TASA_DE_CAMBIO_DEBE_SER_MAYOR_A_CERO = "La tasa de cambio debe ser mayor a cero";
    private String codigo;
    private Double valor;
    private Double tasaCambio;

    public Dinero(String codigo, Double valor, Double tasaCambio) {
        validarObligatorio(codigo,EL_CODIGO_DE_MONEDA_ES_OBLIGATORIO);
        validarObligatorio(valor,EL_CAMPO_DE_VALOR_ES_OBLIGATORIO);
        validarObligatorio(tasaCambio,LA_TASA_DE_CAMBIO_ES_OBLIGATORIO);
        validarPositivo(tasaCambio,LA_TASA_DE_CAMBIO_DEBE_SER_MAYOR_A_CERO);
        this.codigo = codigo;
        this.valor = valor;
        this.tasaCambio = tasaCambio;
    }
}
