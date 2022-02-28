package com.ceiba.credito.adaptador.dao;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.modelo.enumeracion.EnumEstado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class MapeoCreditoTest {

    ResultSet resultSet;
    private MapeoCredito mapeoCredito;
    DtoCredito dtoCredito;

    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private LocalDate fechaSolicitud;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double tasaCambio;
    private Double valorPrestamo;
    private Double valorDividendo;
    private LocalDate fechaPrimeraCuota;
    private EnumEstado estado;

    @BeforeEach
    void inicializar() {
        resultSet = Mockito.mock(ResultSet.class);
        mapeoCredito = new MapeoCredito();
        numeroIdentificacion = "02012";
        tipoIdentificacion = "C";
        fechaSolicitud = convertirDateToLocalDate(new Date());
        ingresoMensual = 1500.00;
        egresoMensual = 950.00;
        codigoMoneda = "USD";
        plazo = 12;
        tasaCambio = 3985.12;
        valorPrestamo = 3562.00;
        valorDividendo = 250.00;
        fechaPrimeraCuota = convertirDateToLocalDate(new Date());
        estado = EnumEstado.INGRESADO;

    }

    @Test
    @DisplayName("Debería crear un objeto tipo DtaCredito")
    void deberiaCrearUnObjetoDtoCreditoDeResulset() throws SQLException  {
        java.sql.Date fecha = new java.sql.Date((new Date()).getTime());
        Mockito.when(resultSet.getString("numero_identificacion")).thenReturn(numeroIdentificacion);
        Mockito.when(resultSet.getString("tipo_identificacion")).thenReturn(tipoIdentificacion);
        Mockito.when(resultSet.getDate("fecha_solicitud")).thenReturn(fecha);
        Mockito.when(resultSet.getDouble("ingreso_mensual")).thenReturn(ingresoMensual);
        Mockito.when(resultSet.getDouble("egreso_mensual")).thenReturn(egresoMensual);
        Mockito.when(resultSet.getString("codigo_moneda")).thenReturn(codigoMoneda);
        Mockito.when(resultSet.getInt("plazo")).thenReturn(plazo);
        Mockito.when(resultSet.getDouble("tasa_cambio")).thenReturn(tasaCambio);
        Mockito.when(resultSet.getDouble("valor_prestamo")).thenReturn(valorPrestamo);
        Mockito.when(resultSet.getDouble("valor_dividendo")).thenReturn(valorDividendo);
        Mockito.when(resultSet.getDate("fecha_primera_cuota")).thenReturn(fecha);
        Mockito.when(resultSet.getString("estado")).thenReturn(estado.getCodigo());
        mapeoCredito.mapRow(resultSet,1);
        DtoCredito dtoCredito = mapeoCredito.mapRow(resultSet,1);
        assertEquals(numeroIdentificacion,dtoCredito.getNumeroIdentificacion());
        assertEquals(tipoIdentificacion,dtoCredito.getTipoIdentificacion());
        assertEquals(fechaSolicitud,dtoCredito.getFechaSolicitud());
        assertEquals(ingresoMensual,dtoCredito.getIngresoMensual());
        assertEquals(egresoMensual,dtoCredito.getEgresoMensual());
        assertEquals(ingresoMensual,dtoCredito.getIngresoMensual());
        assertEquals(codigoMoneda,dtoCredito.getCodigoMoneda());
        assertEquals(plazo,dtoCredito.getPlazo());
        assertEquals(valorPrestamo,dtoCredito.getValorPrestamo());
        assertEquals(valorDividendo,dtoCredito.getValorDividendo());
        assertEquals(estado.getCodigo(),dtoCredito.getEstado());
    }

    private LocalDate convertirDateToLocalDate(Date fechaEntrada) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEntrada);
        return LocalDate.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }


}