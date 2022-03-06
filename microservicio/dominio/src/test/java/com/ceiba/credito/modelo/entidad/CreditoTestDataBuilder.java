package com.ceiba.credito.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.DtoClienteTestDataBuilder;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.credito.modelo.enumeracion.EnumEstado;
import com.ceiba.credito.modelo.enumeracion.EnumPlazo;
import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.dinero.modelo.entidad.DineroTestDataBuilder;

import java.time.LocalDate;


public class CreditoTestDataBuilder {
    private Long codigo;
    private Cliente cliente;
    private LocalDate fechaSolicitud;
    private Dinero ingresoMensual;
    private Dinero egresoMensual;
    private EnumPlazo plazo;
    private Dinero valorPrestamo;
    private Dinero valorDividendo;
    private LocalDate fechaPrimeraCuota;
    private EnumEstado estado;

    public CreditoTestDataBuilder() {
        this.cliente = new Cliente(null, EnumTipoIdentificacion.CEDULA.getTipoIdentificacion("C"),"020120018");
        this.fechaSolicitud = LocalDate.of(2022,03,10);
        this.ingresoMensual = DineroTestDataBuilder.aDinero()
                .conValor(1500.00).conTasaCambio(3945.12).build();
        this.egresoMensual = DineroTestDataBuilder.aDinero()
                .conValor(1200.00).conTasaCambio(3945.12).build();
        this.plazo = EnumPlazo.SEIS;
        this.fechaSolicitud = LocalDate.now();
    }

    public static CreditoTestDataBuilder aCredito() {
        return new CreditoTestDataBuilder();
    }

    public CreditoTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public CreditoTestDataBuilder conFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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


    public CreditoTestDataBuilder conPlazo(EnumPlazo plazo) {
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


    public CreditoTestDataBuilder conFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
        return this;
    }


    public CreditoTestDataBuilder conEstado(EnumEstado estado) {
        this.estado = estado;
        return this;
    }

    public Credito build() {
        Credito credito = new Credito(cliente, ingresoMensual, egresoMensual,  plazo, fechaSolicitud);
        return  credito;
    }

}
