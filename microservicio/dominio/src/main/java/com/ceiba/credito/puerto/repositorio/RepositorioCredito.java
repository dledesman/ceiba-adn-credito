package com.ceiba.credito.puerto.repositorio;


import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.identificacion.modelo.entidad.Identificacion;

import java.util.List;

public interface RepositorioCredito {

    Long crear(Credito credito);

    void actualizar(Credito credito);

    void eliminar(Long id);

    boolean existe(Identificacion identificacion);

    boolean existePorId(Long codigo);
}
