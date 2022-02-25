package com.ceiba.servicio.testdatabuilder;

import com.ceiba.credito.comando.ComandoCredito;

import java.time.LocalDate;

public class ComandoCreditoTestDataBuilder {
    private Long id;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
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

    public ComandoCreditoTestDataBuilder() {
        this.id = 10L;
        this.numeroIdentificacion = "02012";
        this.tipoIdentificacion = "C";
        this.fechaSolicitud = LocalDate.now();
        this.codigoMoneda = "USD";
        this.ingresoMensual = 1500.00;
        this.egresoMensual = 950.00;
        this.plazo = 6;
        this.valorPrestamo=0.00;
        this.valorDividendo=0.00;
        this.tasaCambio = 3941.12;
        this.fechaPrimeraCuota = LocalDate.now();
        this.estado = "Pendiente";
    }

    public static ComandoCreditoTestDataBuilder aComandoCredito() {
        return new ComandoCreditoTestDataBuilder();
    }

    public ComandoCreditoTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ComandoCreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
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

    public ComandoCreditoTestDataBuilder conFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public ComandoCreditoTestDataBuilder conTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
        return this;
    }

    public ComandoCredito build() {
        return new ComandoCredito(this.id,this.numeroIdentificacion,this.tipoIdentificacion,
                this.fechaSolicitud,this.ingresoMensual,this.egresoMensual, this.codigoMoneda,
                this.plazo,this.valorPrestamo,this.valorDividendo,this.tasaCambio,this.fechaPrimeraCuota,this.estado);

    }

}
