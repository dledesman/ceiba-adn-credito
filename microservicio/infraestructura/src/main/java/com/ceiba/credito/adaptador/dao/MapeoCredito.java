package com.ceiba.credito.adaptador.dao;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import java.util.Calendar;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCredito implements RowMapper<DtoCredito>, MapperResult  {

    @Override
    public DtoCredito mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String numeroIdentificacion = resultSet.getString("numero_identificacion");
        String tipoIdentificacion = resultSet.getString("tipo_identificacion");
        LocalDate fechaSolicitud = convertirDateToLocalDate(resultSet.getDate("fecha_solicitud"));
        Double ingresoMensual = resultSet.getDouble("ingreso_mensual");
        Double egresoMensual = resultSet.getDouble("egreso_mensual");
        String codigoMoneda = resultSet.getString("codigo_moneda");
        Integer plazo = resultSet.getInt("plazo");
        Double tasaCambio = resultSet.getDouble("tasa_cambio");
        Double valorPrestamo = resultSet.getDouble("valor_prestamo");
        Double valorDividendo = resultSet.getDouble("valor_dividendo");
        LocalDate fechaPrimeraCuota = convertirDateToLocalDate(resultSet.getDate("fecha_primera_cuota"));
        String estado = resultSet.getString("estado");
        return new DtoCredito(id, tipoIdentificacion, numeroIdentificacion, fechaSolicitud,
                ingresoMensual, egresoMensual, codigoMoneda, plazo, tasaCambio, valorPrestamo, valorDividendo, fechaPrimeraCuota, estado);
    }

    private LocalDate convertirDateToLocalDate(Date fechaEntrada) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEntrada);
        return LocalDate.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }

}

