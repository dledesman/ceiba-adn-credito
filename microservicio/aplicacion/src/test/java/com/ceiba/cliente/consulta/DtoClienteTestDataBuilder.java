package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;

public class DtoClienteTestDataBuilder {

    private Long id;
    private EnumTipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;

    public DtoClienteTestDataBuilder() {
        this.id = 10L;
        this.tipoIdentificacion = EnumTipoIdentificacion.CEDULA;
        this.numeroIdentificacion = "02012";
    }

    public static DtoClienteTestDataBuilder aDtoCliente() {
        return new DtoClienteTestDataBuilder();
    }

    public DtoClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoClienteTestDataBuilder conTipoIdentificacion(EnumTipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public DtoClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public DtoCliente build() {
        return new DtoCliente(this.id,this.tipoIdentificacion,this.numeroIdentificacion);
    }
}
