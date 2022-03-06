package com.ceiba.credito.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoMensajeRespuesta {
    String codigo;
    String descripcion;

    public DtoMensajeRespuesta(String codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
