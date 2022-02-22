package com.ceiba.identificacion.modelo.entidad;

public class IdentificacionTestDataBuilder {

    private String tipoIdentificacion;
    private String numeroIdentificacion;

    public static IdentificacionTestDataBuilder anIdentificacion(){
        return new IdentificacionTestDataBuilder();
    }

    public IdentificacionTestDataBuilder() {
        this.tipoIdentificacion = "C";
        this.numeroIdentificacion = "02012001";
    }

    public IdentificacionTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public IdentificacionTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public Identificacion build() {
        return new Identificacion(tipoIdentificacion, numeroIdentificacion);
    }


}
