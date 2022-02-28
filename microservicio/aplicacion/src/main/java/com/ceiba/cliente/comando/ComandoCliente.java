package com.ceiba.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComandoCliente {
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
