package com.ceiba.cliente.modelo.dto;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
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
    private EnumTipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
}
