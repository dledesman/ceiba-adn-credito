package com.ceiba.cliente.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
