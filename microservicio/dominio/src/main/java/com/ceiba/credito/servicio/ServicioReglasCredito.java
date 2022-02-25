package com.ceiba.credito.servicio;

import com.ceiba.credito.modelo.entidad.Credito;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioReglasCredito {

    private static final Double TASA_INTERES = 8.50/100;
    private static final Double FACTOR_DE_INTERES = TASA_INTERES / 12;
    private static final Double FACTOR_DE_TIEMPO = 1 / ( 1+ FACTOR_DE_INTERES);

    private Credito credito;




    public ServicioReglasCredito(Credito credito) {
        this.credito = credito;
    }

    public Credito calcularValorPrestamo() {
        Double plazo = Double.parseDouble(credito.getPlazo().toString());
        credito.setValorDividendo(credito.getIngresoMensual() - credito.getEgresoMensual());
        double valorCredito = Math.round(credito.getValorDividendo() * (1 - Math.pow(FACTOR_DE_TIEMPO , plazo)) / (FACTOR_DE_INTERES));
        credito.setValorPrestamo(valorCredito);
        credito.setFechaPrimeraCuota(determinarFechaVencimientoPrimeroCuota(credito.getFechaSolicitud()));

        return credito;
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

}
