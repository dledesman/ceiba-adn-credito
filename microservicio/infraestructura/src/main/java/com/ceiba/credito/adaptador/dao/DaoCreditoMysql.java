package com.ceiba.credito.adaptador.dao;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.credito.puerto.dao.DaoCredito;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoCreditoMysql implements DaoCredito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="credito", value="listar")
    private static String sqlListar;

    public DaoCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCredito> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCredito());
    }
}
