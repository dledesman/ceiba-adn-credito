package com.ceiba.cliente.modelo.entidad;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import lombok.Getter;
import lombok.Setter;
import static  com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class Cliente {

    private static final String TIPO_DE_IDENTIFICACION_OBLIGATORIO = "El tipo de identificación es obligatorio";
    private static final String NUMERO_DE_IDENTIFICACION_OBLIGATORIO = "El número de identificación es obligatorio";
    private Long id;
    private EnumTipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;

    public Cliente() {}
    public Cliente(Long id, EnumTipoIdentificacion tipoIdentificacion, String numeroIdentificacion) {
        validarObligatorio(tipoIdentificacion,TIPO_DE_IDENTIFICACION_OBLIGATORIO);
        validarObligatorio(numeroIdentificacion,NUMERO_DE_IDENTIFICACION_OBLIGATORIO);
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
    }
}
