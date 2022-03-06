package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class RepositorioClienteMySql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final Logger LOG = Logger.getLogger("RepositorioClienteMySql.class");

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExiste;

    public RepositorioClienteMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoCliente crear(Cliente cliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoIdentificacion", cliente.getTipoIdentificacion().getCodigo());
        paramSource.addValue("numeroIdentificacion", cliente.getNumeroIdentificacion());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sqlCrear, paramSource,keyHolder,new String[] { "id" });
        return consultar(cliente.getTipoIdentificacion().getCodigo(), cliente.getNumeroIdentificacion());
    }

    @Override
    public DtoCliente consultar(String tipoIdentificacion, String numeroIdentificacion) {
        Optional<DtoCliente> oCliente = ejecutarConsulta(tipoIdentificacion, numeroIdentificacion);
        return oCliente.isPresent() ? oCliente.get()
                : crear(new Cliente(null, EnumTipoIdentificacion.CEDULA.getTipoIdentificacion(tipoIdentificacion), numeroIdentificacion));

    }

    private Optional<DtoCliente> ejecutarConsulta(String tipoIdentificacion, String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoIdentificacion", tipoIdentificacion);
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);
        try {
            return Optional.ofNullable(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlExiste, paramSource, BeanPropertyRowMapper.newInstance(DtoCliente.class)));
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
            return Optional.empty();
        }
    }
}
