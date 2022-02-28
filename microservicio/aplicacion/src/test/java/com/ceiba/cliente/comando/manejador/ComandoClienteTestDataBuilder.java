package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;

    public ComandoClienteTestDataBuilder() {
        this.id = 10L;
        this.tipoIdentificacion = "C";
        this.numeroIdentificacion = "02012";
    }

    public static ComandoClienteTestDataBuilder aComandoCliente() {
        return new ComandoClienteTestDataBuilder();
    }

    public ComandoClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ComandoClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(this.id, this.tipoIdentificacion, this.numeroIdentificacion);
    }
}
