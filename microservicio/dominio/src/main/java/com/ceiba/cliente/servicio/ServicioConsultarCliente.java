package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioConsultarCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioConsultarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public DtoCliente ejecutar(String tipoIdentificacion, String numeroIdentificacion) {
         DtoCliente dtoCliente = null;
        try {
            dtoCliente = repositorioCliente
                    .consultar(tipoIdentificacion, numeroIdentificacion);
            return dtoCliente;
        } catch (Exception ex)  {
            Cliente cliente = new Cliente(null,
                    EnumTipoIdentificacion.CEDULA.getTipoIdentificacion(tipoIdentificacion), numeroIdentificacion);
            return repositorioCliente.crear(cliente);
        }
   }
}
