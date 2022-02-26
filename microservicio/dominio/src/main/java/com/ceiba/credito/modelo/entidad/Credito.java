package com.ceiba.credito.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.credito.modelo.enumeracion.EnumEstado;
import com.ceiba.credito.modelo.enumeracion.EnumPlazo;
import com.ceiba.dinero.modelo.entidad.Dinero;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Getter
public class Credito {
    private static final Double TASA_INTERES = 8.50/100;
    private static final Double FACTOR_DE_INTERES = TASA_INTERES / 12;
    private static final Double FACTOR_DE_TIEMPO = 1 / ( 1+ FACTOR_DE_INTERES);
    private static final String EL_CLIENTE_ES_OBLIGATORIO = "El cliente es obligatorio para registro de la solicitud";
    private static final String EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO = "El campo de valor de ingresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO = "El campo de valor de egresos mensuales es obligatorio";
    private static final String EL_VALOR_DE_PLAZO_ES_OBLIGATORIO = "El campo de valor de plazo es obligatorio";
    private static final String EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO = "El valor de ingresos  mensuales debe ser mayor a cero";
    private static final String EL_VALOR_DE_EGRESOS_DEBE_SER_MAYOR_A_CERO = "El valor de egresos  mensuales debe ser mayor a cero";
    private static final String EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS = "El valor de egeresos  mensuales debe ser menor que los ingresos";
    private static final String EL_VALOR_DE_TASA_CAMBIO_ES_OBLIGATORIO = "El valor de la tasa de cambio en los ingresos es obligatorio";
    private Long id;
    private Cliente cliente;
    private LocalDate fechaSolicitud;
    private Dinero ingresoMensual;
    private Dinero egresoMensual;
    private EnumPlazo plazo;
    private Dinero valorPrestamo;
    private Dinero valorDividendo;
    private LocalDate fechaPrimeraCuota;
    private EnumEstado estado;

    public Credito(Cliente cliente, Dinero ingresoMensual, Dinero egresoMensual, EnumPlazo plazo, LocalDate fechaSolicitud) {
        validarObligatorio(cliente,EL_CLIENTE_ES_OBLIGATORIO);
        validarObligatorio(ingresoMensual,EL_VALOR_DE_INGRESOS_ES_OBLIGATORIO);
        validarObligatorio(egresoMensual,EL_VALOR_DE_EGRESOS_ES_OBLIGATORIO);
        validarObligatorio(plazo,EL_VALOR_DE_PLAZO_ES_OBLIGATORIO);
        validarPositivo(ingresoMensual.getValor(),EL_VALOR_DE_INGRESOS_DEBE_SER_MAYOR_A_CERO);
        validarPositivo(egresoMensual.getValor(),EL_VALOR_DE_EGRESOS_DEBE_SER_MAYOR_A_CERO);
        validarMenor(egresoMensual.getValor(), ingresoMensual.getValor(),EL_VALOR_DE_EGRESOS_DEBE_SER_MENOR_A_INGRESOS);
        validarObligatorio(ingresoMensual.getTasaCambio(), EL_VALOR_DE_TASA_CAMBIO_ES_OBLIGATORIO);
        this.cliente = cliente;
        this.ingresoMensual = ingresoMensual;
        this.egresoMensual = egresoMensual;
        this.plazo = plazo;
        this.estado = EnumEstado.INGRESADO;
        this.fechaSolicitud = fechaSolicitud;
        this.calcularValorPrestamo();
    }

    private void calcularValorPrestamo() {
        if (null == this.valorPrestamo || this.valorPrestamo.getValor() == 0) {
            Double plazoCredito = Double.parseDouble(this.getPlazo().getNumero().toString());
            this.valorDividendo = new Dinero(getIngresoMensual().getMoneda(),
                this.getIngresoMensual().getValor() - this.getEgresoMensual().getValor(),
                      getIngresoMensual().getTasaCambio());
            double montoAprobado = Math.round(this.getValorDividendo().getValor() * (1 - Math.pow(FACTOR_DE_TIEMPO , plazoCredito)) / (FACTOR_DE_INTERES));
            valorPrestamo = new Dinero(getIngresoMensual().getMoneda(),montoAprobado,
                    getIngresoMensual().getTasaCambio());
            fechaPrimeraCuota = (determinarFechaVencimientoPrimeroCuota(this.fechaSolicitud));
        }
    }

    private LocalDate determinarFechaVencimientoPrimeroCuota(LocalDate fechaInicial) {
        Integer diaDelMes = fechaInicial.getDayOfMonth();
        LocalDate fechaUltimoDiaSiguienteMes = fechaInicial.plusMonths(2)
                .minusDays(Long.parseLong(diaDelMes.toString()));
        boolean esFinDeSemana = true;
        while (esFinDeSemana) {
            if (!(fechaUltimoDiaSiguienteMes.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    fechaUltimoDiaSiguienteMes.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                esFinDeSemana = false;
            } else  {
                fechaUltimoDiaSiguienteMes = fechaUltimoDiaSiguienteMes.minusDays(1);
            }
        }
        return fechaUltimoDiaSiguienteMes;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
