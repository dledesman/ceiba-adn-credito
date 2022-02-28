package com.ceiba.credito.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", credito.getCliente().getId());
        paramSource.addValue("fechaSolicitud", credito.getCliente().getId());
        paramSource.addValue("ingresoMensual",credito.getIngresoMensual().getValor());
        paramSource.addValue("egresoMensual",credito.getEgresoMensual().getValor());
        paramSource.addValue("codigoMoneda",credito.getIngresoMensual().getMoneda());
        paramSource.addValue("plazo",credito.getPlazo().getNumero());
        paramSource.addValue("tasaCambio",credito.getIngresoMensual().getTasaCambio());
        paramSource.addValue("valorPrestamo",credito.getValorPrestamo().getValor());
        paramSource.addValue("valorDividendo",credito.getValorDividendo().getValor());
        paramSource.addValue("fechaPrimeraCuota",credito.getFechaPrimeraCuota());
        paramSource.addValue("estado",credito.getEstado().getCodigo());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
            .update(sqlCrear, paramSource,keyHolder,new String[] { "id" });
        return keyHolder.getKey().longValue();
    }

    @Override
    public void actualizar(Credito credito) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", credito.getCliente().getId());
        paramSource.addValue("estado",credito.getEstado().getCodigo());
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
            .update(sqlActualizar, paramSource);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Cliente cliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cliente", cliente.getId());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
