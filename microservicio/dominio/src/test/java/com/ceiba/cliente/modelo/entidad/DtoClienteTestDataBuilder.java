package com.ceiba.cliente.modelo.entidad;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;

public class DtoClienteTestDataBuilder {

    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private Long id;

    public DtoClienteTestDataBuilder() {
        this.numeroIdentificacion = "020120018";
        this.tipoIdentificacion = "C";
    }

    public static DtoClienteTestDataBuilder aDtoCliente() {
        return new DtoClienteTestDataBuilder();
    }

    public DtoClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public DtoClienteTestDataBuilder conCodigo(Long id) {
        this.id = id;
        return this;
    }

    public DtoClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public DtoCliente build() {
        return new DtoCliente(id, tipoIdentificacion, numeroIdentificacion);
    }
}
