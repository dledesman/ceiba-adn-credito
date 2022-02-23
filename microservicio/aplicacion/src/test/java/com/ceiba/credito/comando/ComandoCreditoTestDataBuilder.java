package com.ceiba.credito.comando;

import java.util.Date;

public class ComandoCreditoTestDataBuilder {
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String monedaTransaccion;
    private Double ingresoMensual;
    private Double egresoMensual;
    private Integer plazo;
    private Double valorPrestamo;
    private Double valorDividendo;
    private Date fechaPrimeraCuota;

    public ComandoCreditoTestDataBuilder() {
        this.numeroIdentificacion = "02012";
        this.tipoIdentificacion = "C";
        this.monedaTransaccion = "USD";
        this.ingresoMensual = 1500.00;
        this.egresoMensual = 950.00;
        this.plazo = 6;
        this.valorPrestamo=0.00;
        this.valorDividendo=0.00;
        this.fechaPrimeraCuota = new Date();
    }

    public static ComandoCreditoTestDataBuilder aComandoCredito() {
        return new ComandoCreditoTestDataBuilder();
    }

    public ComandoCreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conMonedaTransaccion(String monedaTransaccion) {
        this.monedaTransaccion = monedaTransaccion;
        return this;
    }


    public ComandoCreditoTestDataBuilder conIngresoMensual(Double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
        return this;
    }

    public ComandoCreditoTestDataBuilder conEgresoMensual(Double egresoMensual) {
        this.egresoMensual = egresoMensual;
        return this;
    }

    public ComandoCreditoTestDataBuilder conPlazo(Integer plazo) {
        this.plazo = plazo;
        return this;
    }

    public ComandoCreditoTestDataBuilder conValorPrestamo(Double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
        return this;
    }

    public ComandoCreditoTestDataBuilder conValorDividendo(Double valorDividendo) {
        this.valorDividendo = valorDividendo;
        return this;
    }

    public ComandoCreditoTestDataBuilder conFechaPrimeraCuota(Date fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public ComandoCredito build() {
        return new ComandoCredito(this.numeroIdentificacion,this.tipoIdentificacion,
                this.monedaTransaccion,this.ingresoMensual,this.egresoMensual,
                this.plazo,this.valorPrestamo,this.valorDividendo,this.fechaPrimeraCuota);

    }

}
