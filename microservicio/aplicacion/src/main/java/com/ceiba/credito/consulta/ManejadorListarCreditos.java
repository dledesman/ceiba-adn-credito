package com.ceiba.credito.consulta;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.credito.puerto.dao.DaoCredito;

import java.util.List;

public class ManejadorListarCreditos {

    private final DaoCredito daoCredito;

    public ManejadorListarCreditos(DaoCredito daoCredito) {
        this.daoCredito = daoCredito;
    }

    public List<DtoCredito> ejecutar() {
        return daoCredito.listar();
    }
}
