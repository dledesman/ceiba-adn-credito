package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioConsultarCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioConsultarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public DtoCliente ejecutar(String tipoIdentificacion, String numeroIdentificacion) {
        return repositorioCliente.consultar(tipoIdentificacion, numeroIdentificacion);
   }
}
