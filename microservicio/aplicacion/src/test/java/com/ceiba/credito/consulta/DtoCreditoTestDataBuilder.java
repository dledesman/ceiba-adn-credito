package com.ceiba.credito.consulta;

import com.ceiba.credito.modelo.dto.DtoCredito;

import java.time.LocalDate;

public class DtoCreditoTestDataBuilder {
    private String numeroIdentificacion;
    private Long id;
    private LocalDate fechaSolicitud;
    private String tipoIdentificacion;
    private Double egresoMensual;
    private Double ingresoMensual;
    private Integer plazo;
    private String codigoMoneda;
    private Double valorDividendo;
    private Double valorPrestamo;
    private LocalDate fechaPrimeraCuota;
    private String estado;
    private Double tasaCambio;

    public DtoCreditoTestDataBuilder() {
        this.tipoIdentificacion = "C";
        this.numeroIdentificacion = "02012";
        this.id = 10L;
        this.fechaSolicitud = LocalDate.now();
        this.egresoMensual = 950.00;
        this.ingresoMensual = 1500.00;
        this.codigoMoneda = "USD";
        this.valorPrestamo=0.00;
        this.plazo = 6;
        this.tasaCambio=3491.12;
        this.valorDividendo=0.00;
        this.estado = "Ingresado";
        this.fechaPrimeraCuota = LocalDate.now();
    }

    public static DtoCreditoTestDataBuilder aDtoCredito() {
        return new DtoCreditoTestDataBuilder();
    }

    public DtoCreditoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoCreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public DtoCreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public DtoCreditoTestDataBuilder conCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
        return this;
    }


    public DtoCreditoTestDataBuilder conIngresoMensual(Double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
        return this;
    }

    public DtoCreditoTestDataBuilder conEgresoMensual(Double egresoMensual) {
        this.egresoMensual = egresoMensual;
        return this;
    }

    public DtoCreditoTestDataBuilder conPlazo(Integer plazo) {
        this.plazo = plazo;
        return this;
    }

    public DtoCreditoTestDataBuilder conValorPrestamo(Double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
        return this;
    }

    public DtoCreditoTestDataBuilder conValorDividendo(Double valorDividendo) {
        this.valorDividendo = valorDividendo;
        return this;
    }

    public DtoCreditoTestDataBuilder conFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public DtoCreditoTestDataBuilder conTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
        return this;
    }

    public DtoCredito build() {
        return new DtoCredito(id, tipoIdentificacion, numeroIdentificacion, fechaSolicitud, ingresoMensual, egresoMensual,
                codigoMoneda, tasaCambio, plazo, valorPrestamo, valorDividendo, fechaPrimeraCuota, estado);

    }

}
