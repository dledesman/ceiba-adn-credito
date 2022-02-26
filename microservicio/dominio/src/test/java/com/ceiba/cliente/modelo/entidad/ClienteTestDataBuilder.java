package com.ceiba.cliente.modelo.entidad;

import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;

public class ClienteTestDataBuilder {

    private String numeroIdentificacion;
    private EnumTipoIdentificacion tipoIdentificacion;
    private Long id;

    public ClienteTestDataBuilder() {
        this.numeroIdentificacion = "020120018";
        this.tipoIdentificacion = EnumTipoIdentificacion.CEDULA;
    }

    public static ClienteTestDataBuilder aCliente() {
        return new ClienteTestDataBuilder();
    }

    public ClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ClienteTestDataBuilder conCodigo(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conTipoIdentificacion(EnumTipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public Cliente build() {
        return new Cliente(id, tipoIdentificacion, numeroIdentificacion);
    }
}
