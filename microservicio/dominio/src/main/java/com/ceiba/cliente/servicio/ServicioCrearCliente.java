package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {

    private static final String CLIENTE_YA_RESGITRADO = "El cliente ya se encuentra registrado";
    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {
        validarClienteYaRegistrado(cliente.getTipoIdentificacion(), cliente.getNumeroIdentificacion());
        return  repositorioCliente.crear(cliente);
    }

    private void validarClienteYaRegistrado(EnumTipoIdentificacion tipoIdentificacion, String numeroIdentificacion) {
        if (repositorioCliente.existe(tipoIdentificacion, numeroIdentificacion)) {
            throw new ExcepcionDuplicidad(CLIENTE_YA_RESGITRADO);
        }
    }

}
