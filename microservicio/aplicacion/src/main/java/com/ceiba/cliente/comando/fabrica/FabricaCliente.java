package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {
    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getId(),
                EnumTipoIdentificacion.CEDULA.getTipoIdentificacion(comandoCliente.getTipoIdentificacion()),
                comandoCliente.getNumeroIdentificacion());
    }
}
