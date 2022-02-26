package com.ceiba.cliente.consulta;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;

public class ManejadorConsultaCliente {

    private final DaoCliente daoCliente;

    public ManejadorConsultaCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public DtoCliente ejecutar(ComandoCliente comandoCliente) {
        return daoCliente.consultar(comandoCliente.getTipoIdentificacion(),
                comandoCliente.getNumeroIdentificacion());
    }
}

