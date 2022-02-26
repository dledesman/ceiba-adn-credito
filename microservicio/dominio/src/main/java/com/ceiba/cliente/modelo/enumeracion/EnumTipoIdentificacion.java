package com.ceiba.cliente.modelo.enumeracion;

public enum EnumTipoIdentificacion {

    CEDULA("C"),
    PASAPORTE("P"),
    OTRO("0");

    private final String codigo;

    private EnumTipoIdentificacion(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return this.codigo;
    }

    public EnumTipoIdentificacion getTipoIdentificacion(String codigo) {
        for(EnumTipoIdentificacion tipoIdentificacion: values()) {
            if(tipoIdentificacion.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoIdentificacion;
            }
        }
        return CEDULA;
    }

}
