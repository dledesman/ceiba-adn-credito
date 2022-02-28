package com.ceiba.credito.comando;

public class ComandoCreditoTestDataBuilder {
    private Long id;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private Double ingresoMensual;
    private Double egresoMensual;
    private String codigoMoneda;
    private Integer plazo;
    private Double tasaCambio;

    public ComandoCreditoTestDataBuilder() {
        this.id = 10L;
        this.tipoIdentificacion = "C";
        this.numeroIdentificacion = "02012";
        this.ingresoMensual = 1500.00;
        this.egresoMensual = 950.00;
        this.codigoMoneda = "USD";
        this.plazo = 6;
        this.tasaCambio = 3941.12;
    }

    public static ComandoCreditoTestDataBuilder aComandoCredito() {
        return new ComandoCreditoTestDataBuilder();
    }



    public ComandoCreditoTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCreditoTestDataBuilder conCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
        return this;
    }

    public ComandoCreditoTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ComandoCreditoTestDataBuilder conEgresoMensual(Double egresoMensual) {
        this.egresoMensual = egresoMensual;
        return this;
    }

    public ComandoCreditoTestDataBuilder conIngresoMensual(Double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
        return this;
    }

    public ComandoCredito build() {
        return new ComandoCredito(this.id, this.tipoIdentificacion, this.numeroIdentificacion,
                this.ingresoMensual,this.egresoMensual, this.codigoMoneda,
                this.plazo,this.tasaCambio);
    }

    public ComandoCreditoTestDataBuilder conTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
        return this;
    }

    public ComandoCreditoTestDataBuilder conPlazo(Integer plazo) {
        this.plazo = plazo;
        return this;
    }


}
