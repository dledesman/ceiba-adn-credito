package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;

public interface RepositorioCliente {

    DtoCliente crear(Cliente cliente);

    DtoCliente consultar(String tipoIdentificacion, String numeroIdentificacion);

}
