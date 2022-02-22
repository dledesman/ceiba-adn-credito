package com.ceiba.credito.consulta;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import java.util.List;

public class ManejadorListarCreditos {

    private DaoUsuario daoUsuario;

    public ManejadorListarCreditos(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar() {
        return daoUsuario.listar();
    }
}
