package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(Long id);

    boolean existe(EnumTipoIdentificacion tipoIdentificacion, String numeroIdentificacion);

    boolean existePorId(Long iD);

    boolean tieneSolicitudesIngresadas(Long id);

}
