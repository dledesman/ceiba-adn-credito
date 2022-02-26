package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioEliminarCliente {

    private static final String CLIENTE_NO_EXISTE = "El cliente no está registrado";
    private static final String CLIENTE_NO_TIENE_SOLICITUDES = "El cliente tiene solicitudes de crédito registradas";
    private RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        validarExistenciaCliente(id);
        validarSolicitudesRegistradas(id);
        repositorioCliente.eliminar(id);
    }

    private void validarExistenciaCliente(Long id) {
        if (!repositorioCliente.existePorId(id)) {
            throw new ExcepcionSinDatos(CLIENTE_NO_EXISTE);
        }
    }

    private void validarSolicitudesRegistradas(Long id) {
        if (repositorioCliente.tieneSolicitudesIngresadas(id)) {
            throw new ExcepcionDuplicidad(CLIENTE_NO_TIENE_SOLICITUDES);
        }
    }

}
