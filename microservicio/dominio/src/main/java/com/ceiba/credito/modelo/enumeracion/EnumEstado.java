package com.ceiba.credito.modelo.enumeracion;



public enum EnumEstado {
    INGRESADO("I"),
    PROCESADO("P"),
    RECHAZADO("R");

    private final String codigo;

    private EnumEstado(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public EnumEstado getEstado(String codigo) {
        for(EnumEstado estado: values()) {
            if(estado.getCodigo().equalsIgnoreCase(codigo)) {
                return estado;
            }
        }
        return INGRESADO;
    }
}
