package com.ceiba.cliente.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCliente {
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
