package com.ceiba.dinero.modelo.entidad;

import com.ceiba.dinero.modelo.enumeracion.EnumMoneda;

public class DineroTestDataBuilder {

    private EnumMoneda moneda;
    private Double valor;
    private Double tasaCambio;

    public DineroTestDataBuilder() {
        this.moneda = EnumMoneda.DOLAR;
        this.valor = 1500.00;
        this.tasaCambio = 3974.12;
    }

    public static DineroTestDataBuilder aDinero() {
        return new DineroTestDataBuilder();
    }

    public DineroTestDataBuilder conMoneda(EnumMoneda moneda) {
        this.moneda = moneda;
        return this;
    }

    public DineroTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public DineroTestDataBuilder conTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
        return this;
    }
    public Dinero build() {
        return new Dinero(this.moneda, this.valor, this.tasaCambio);
    }
}
