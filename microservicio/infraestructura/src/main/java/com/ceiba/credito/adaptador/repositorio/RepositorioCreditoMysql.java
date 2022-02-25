package com.ceiba.credito.adaptador.repositorio;

import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCreditoMysql implements RepositorioCredito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="credito", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="credito", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="credito", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="credito", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="credito", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Credito credito) {
        return this.customNamedParameterJdbcTemplate.crear(credito, sqlCrear);
    }

    @Override
    public void actualizar(Credito credito) {
        customNamedParameterJdbcTemplate.actualizar(credito, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
