package com.ceiba.dinero.modelo.entidad;

import java.util.UUID;

public class DineroTestDataBuilder {
    private String codigo;
    private Double valor;
    private Double tasaCambio;

    public DineroTestDataBuilder() {
        this.codigo = "USD";
         this.valor = 10.00;
        this.tasaCambio = 1.00;
    }

    public  static DineroTestDataBuilder aDinero() {
        return new DineroTestDataBuilder();
    }

    public DineroTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
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
        return new Dinero(codigo,valor,tasaCambio);
    }
}
