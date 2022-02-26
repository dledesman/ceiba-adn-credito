package com.ceiba.credito.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.credito.modelo.entidad.Credito;

public interface RepositorioCredito {

    Long crear(Credito credito);

    void actualizar(Credito credito);

    void eliminar(Long id);

    boolean existe(Cliente cliente);

    boolean existePorId(Long codigo);
}
