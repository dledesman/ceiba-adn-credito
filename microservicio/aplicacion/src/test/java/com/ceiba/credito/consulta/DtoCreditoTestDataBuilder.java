package com.ceiba.credito.consulta;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.modelo.dto.DtoCredito;

import java.util.Date;

public class DtoCreditoTestDataBuilder {

    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String monedaTransaccion;
    private Double ingresoMensual;
    private Double egresoMensual;
    private Integer plazo;
    private Double valorPrestamo;
    private Double valorDividendo;
    private Date fechaPrimeraCuota;

    public DtoCreditoTestDataBuilder() {
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

    public static DtoCreditoTestDataBuilder aDtoCredito() {
        return new DtoCreditoTestDataBuilder();
    }

    public DtoCreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public DtoCreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public DtoCreditoTestDataBuilder conMonedaTransaccion(String monedaTransaccion) {
        this.monedaTransaccion = monedaTransaccion;
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

    public DtoCreditoTestDataBuilder conFechaPrimeraCuota(Date fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public DtoCredito build() {
        return new DtoCredito(this.numeroIdentificacion,this.tipoIdentificacion,
                this.monedaTransaccion,this.ingresoMensual,this.egresoMensual,
                this.plazo,this.valorPrestamo,this.valorDividendo,this.fechaPrimeraCuota);

    }

}
