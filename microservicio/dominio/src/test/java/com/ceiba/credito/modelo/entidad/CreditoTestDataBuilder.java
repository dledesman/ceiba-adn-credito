package com.ceiba.credito.modelo.entidad;

import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.identificacion.modelo.entidad.Identificacion;

import java.util.Date;
import static com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder.aDinero;
import static com.ceiba.identificacion.modelo.entidad.IdentificacionTestDataBuilder.anIdentificacion;

public class CreditoTestDataBuilder {
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

    public CreditoTestDataBuilder() {
        this.identificacion = anIdentificacion().build();
        this.ingresoMensual = aDinero().conValor(1000.00).build();
        this.egresoMensual = aDinero().conValor(800.00).build();
        this.plazo = 6;
    }

    public static CreditoTestDataBuilder aCredito() {
        return new CreditoTestDataBuilder();
    }

    public CreditoTestDataBuilder conIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public CreditoTestDataBuilder conIngresoMensual(Dinero ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
        return this;
    }

    public CreditoTestDataBuilder conEgresoMensual(Dinero egresoMensual) {
        this.egresoMensual = egresoMensual;
        return this;
    }

    public CreditoTestDataBuilder conPlazo(Integer plazo) {
        this.plazo = plazo;
        return this;
    }

    public CreditoTestDataBuilder conValorPrestamo(Dinero valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
        return this;
    }

    public CreditoTestDataBuilder conValorDividendo(Dinero valorDividendo) {
        this.valorDividendo = valorDividendo;
        return this;
    }

    public CreditoTestDataBuilder conFechaPrimeraCuota(Date fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }

    public CreditoTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Credito build() {
        return new Credito(identificacion,ingresoMensual,egresoMensual,plazo);
    }

}
