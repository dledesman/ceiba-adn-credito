package com.ceiba.identificacion.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import lombok.Getter;

@Getter
public class Identificacion {

    private static final String TIPO_DE_IDENTIFICACION_ES_OBLIGARIO = "El tipo de identificación es un valor obligatorio";
    private static final String NUMERO_DE_IDENTIFICACION_ES_OBLIGARIO = "El número de identificación es un valor obligatorio";

    private  String tipoIdentificacion;
    private String numeroIdentificacion;

    public Identificacion(String tipoIdentificacion, String numeroIdentificacion) {
        validarObligatorio(tipoIdentificacion, TIPO_DE_IDENTIFICACION_ES_OBLIGARIO);
        validarObligatorio(numeroIdentificacion, NUMERO_DE_IDENTIFICACION_ES_OBLIGARIO);
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
    }

}
