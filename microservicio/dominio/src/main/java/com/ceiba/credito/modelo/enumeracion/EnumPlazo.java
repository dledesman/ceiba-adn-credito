package com.ceiba.credito.modelo.enumeracion;

public enum EnumPlazo {
    TRES(3),
    SEIS(6),
    DOCE(12);

    private final Integer numero;

    private EnumPlazo(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public EnumPlazo getPlazo(int numero) {
        for(EnumPlazo plazo: values()) {
            if(plazo.getNumero() == numero) {
                return plazo;
            }
        }
        return DOCE;
    }
}
