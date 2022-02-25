package com.ceiba.credito.modelo.entidad;

import java.time.LocalDate;
import java.util.Date;

public class CreditoTestDataBuilder {
    private Long codigo;
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

    public CreditoTestDataBuilder() {
        this.tipoIdentificacion = "2";
        this.numeroIdentificacion = "02012";
        this.ingresoMensual = 1000.00;
        this.egresoMensual = 800.00;
        this.codigoMoneda = "USD";
        this.plazo = 6;
        this.tasaCambio = 3941.12;
        this.fechaSolicitud = LocalDate.now();
    }

    public static CreditoTestDataBuilder aCredito() {
        return new CreditoTestDataBuilder();
    }

    public CreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public CreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public CreditoTestDataBuilder conIngresoMensual(Double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
        return this;
    }

    public CreditoTestDataBuilder conEgresoMensual(Double egresoMensual) {
        this.egresoMensual = egresoMensual;
        return this;
    }

    public CreditoTestDataBuilder conCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
        return this;
    }

    public CreditoTestDataBuilder conPlazo(Integer plazo) {
        this.plazo = plazo;
        return this;
    }

    public CreditoTestDataBuilder conValorPrestamo(Double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
        return this;
    }

    public CreditoTestDataBuilder conValorDividendo(Double valorDividendo) {
        this.valorDividendo = valorDividendo;
        return this;
    }

    public CreditoTestDataBuilder conTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
        return this;
    }

    public CreditoTestDataBuilder conFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public CreditoTestDataBuilder conFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }

    public CreditoTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Credito build() {
        Credito credito = new Credito(tipoIdentificacion, numeroIdentificacion, ingresoMensual, egresoMensual, codigoMoneda , plazo, tasaCambio);
        credito.setFechaSolicitud(fechaSolicitud);
        return  credito;
    }

}
