package com.ceiba.credito.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarPlazo;

import java.time.LocalDate;

@Getter
public class Credito {
    private static final String EL_TIPO_IDENTIFICACIONS_ES_OBLIGATORIA = "El campo de tipo de identificación es obligatorio";
    private static final String EL_NUMERO_IDENTIFICACIONS_ES_OBLIGATORIA = "El campo de número de identificación es obligatorio";
    private static final String EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO = "El campo de valor de ingresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO = "El campo de valor de egresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_PLAZO_ES_OBLIGATORIO = "El campo de valor de plazo es obligatorio";
    private static final String EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO = "El valor de ingresos  mensuales debe ser mayor a cero";
    private static final String EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS = "El valor de egeresos  mensuales debe ser menor que los ingresos";
    private static final String EL_VALOR_PERMITIDO_PARA_EL_PLAZO_ES_INCORRECTO = "El valor permitido para el plazo es 3, 6 o 12 meses";
    private static final String EL_VALOR_DE_TASA_CAMBIO_ES_OBLIGATORIO = "El campo de tasa de cambio es obligatorio";
    private static final String ESTADO_INICIAL = "Ingresado";
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private LocalDate fechaSolicitud;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double valorPrestamo;
    private Double valorDividendo;
    private Double tasaCambio;
    private LocalDate fechaPrimeraCuota;
    private String estado;

    public Credito(String tipoIdentificacion, String numeroIdentificacion, double ingresoMensual, double egresoMensual, String codigoMoneda, Integer plazo, Double tasaCambio) {
        validarObligatorio(tipoIdentificacion,EL_TIPO_IDENTIFICACIONS_ES_OBLIGATORIA);
        validarObligatorio(numeroIdentificacion,EL_NUMERO_IDENTIFICACIONS_ES_OBLIGATORIA);
        validarMenor(1.00,ingresoMensual,EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO);
        validarMenor(1.00,egresoMensual,EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO);
        validarObligatorio(plazo,EL_VALOR_DE_PLAZO_ES_OBLIGATORIO);
        validarPlazo(plazo,EL_VALOR_PERMITIDO_PARA_EL_PLAZO_ES_INCORRECTO);
        validarPositivo(ingresoMensual,EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO);
        validarMenor(egresoMensual, ingresoMensual,EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS);
        validarMenor(1.00, tasaCambio, EL_VALOR_DE_TASA_CAMBIO_ES_OBLIGATORIO);
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaSolicitud = LocalDate.now();
        this.ingresoMensual = ingresoMensual;
        this.egresoMensual = egresoMensual;
        this.codigoMoneda = codigoMoneda;
        this.plazo = plazo;
        this.tasaCambio = tasaCambio;
        this.estado = ESTADO_INICIAL;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorPrestamo(Double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public void setValorDividendo(Double valorDividendo) {
        this.valorDividendo = valorDividendo;
    }

    public void setTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public void setFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
