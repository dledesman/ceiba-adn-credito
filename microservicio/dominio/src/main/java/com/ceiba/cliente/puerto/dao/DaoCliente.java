package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

public interface DaoCliente {
    DtoCliente consultar(String tipoIdentificacion, String numeroIdentificacion);
}
