package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarCliente {

    private static final String CLIENTE_NO_EXISTE = "No existe el cliente seleccionado para actualización";
    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        verificarExistenciaCliente(cliente.getId());
        repositorioCliente.actualizar(cliente);
    }

    private void verificarExistenciaCliente(Long id) {
        if (!repositorioCliente.existePorId(id)) {
            throw new ExcepcionSinDatos(CLIENTE_NO_EXISTE);
        }
    }
}
