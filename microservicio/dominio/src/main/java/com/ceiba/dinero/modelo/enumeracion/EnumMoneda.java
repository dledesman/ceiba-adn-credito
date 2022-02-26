package com.ceiba.dinero.modelo.enumeracion;

public enum EnumMoneda {
    DOLAR("USD"),
    EURO("EUR"),
    PESO_COLOMBIADO("COP"),
    BOLIVAR_VENEZOLANO("VEF");

    private final String codigo;

    private EnumMoneda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public EnumMoneda getMoneda(String codigo) {
        for(EnumMoneda moneda: values()) {
            if(moneda.getCodigo().equalsIgnoreCase(codigo)) {
                return moneda;
            }
        }
        return DOLAR;
    }

}
