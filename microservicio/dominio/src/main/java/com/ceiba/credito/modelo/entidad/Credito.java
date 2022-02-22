package com.ceiba.credito.modelo.entidad;

import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.identificacion.modelo.entidad.Identificacion;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarPlazo;
import java.util.Date;

@Getter
public class Credito {
    private static final String LA_IDENTIFICACIONS_ES_OBLIGATORIA = "El campo de identificación es obligatorio";
    private static final String EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO = "El campo de valor de ingresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO = "El campo de valor de egresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_PLAZO_ES_OBLIGATORIO = "El campo de valor de plazo es obligatorio";
    private static final String EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO = "El valor de ingresos  mensuales debe ser mayor a cero";
    private static final String EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS = "El valor de egeresos  mensuales debe ser menor que los ingresos";
    private static final String EL_VALOR_PERMITIDO_PARA_EL_PLAZO_ES_INCORRECTO = "El valor permitido para el plazo es 3, 6 o 12 meses";
    private static final String ESTADO_INICIAL = "Ingresado";
    private Long codigo;
    private Identificacion identificacion;
    private Date fechaSolicitud;
    private Dinero ingresoMensual;
    private Dinero egresoMensual;
    private Integer plazo;
    private Dinero valorPrestamo;
    private Dinero valorDividendo;
    private Date fechaPrimeraCuota;
    private String estado;

    public Credito(Identificacion identificacion, Dinero ingresoMensual, Dinero egresoMensual, Integer plazo) {
        validarObligatorio(identificacion,LA_IDENTIFICACIONS_ES_OBLIGATORIA);
        validarObligatorio(ingresoMensual,EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO);
        validarObligatorio(egresoMensual,EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO);
        validarObligatorio(plazo,EL_VALOR_DE_PLAZO_ES_OBLIGATORIO);
        validarPlazo(plazo,EL_VALOR_PERMITIDO_PARA_EL_PLAZO_ES_INCORRECTO);
        validarPositivo(ingresoMensual.getValor(),EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO);
        validarMenor(egresoMensual.getValor(), ingresoMensual.getValor(),EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS);
        this.identificacion = identificacion;
        this.ingresoMensual = ingresoMensual;
        this.egresoMensual = egresoMensual;
        this.plazo = plazo;
        this.estado = ESTADO_INICIAL;
    }

}
