package com.ceiba.credito.adaptador.dao;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class MapeoCredito implements RowMapper<DtoCredito>, MapperResult  {

    @Override
    public DtoCredito mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String numeroIdentificacion = resultSet.getString("identificacion.numeroIdentificacion");
        String tipoIdentificacion = resultSet.getString("identificacion.tipoIdentificacion");
        String monedaTransaccion = resultSet.getString("ingreso_mensual.codigo");
        Double ingresoMensual = resultSet.getDouble("ingreso_ensual.val|or");
        Double egresoMensual = resultSet.getDouble("egreso_mensual.valor");
        Integer plazo = resultSet.getInt("plazo");
        Double valorPrestamo = resultSet.getDouble("valor_prestamo.valor");
        Double valorDividendo = resultSet.getDouble("valor_dividendo.valor");
        Date fechaPrimeraCuota = resultSet.getDate("fecha_primera_cuota");
        return new DtoCredito(id, numeroIdentificacion, tipoIdentificacion, monedaTransaccion,
                ingresoMensual, egresoMensual, plazo, valorPrestamo, valorDividendo, fechaPrimeraCuota);
    }

}

