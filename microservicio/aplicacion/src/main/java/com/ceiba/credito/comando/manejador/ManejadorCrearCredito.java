package com.ceiba.credito.comando.manejador;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.ComandoRespuesta;
import com.ceiba.credito.comando.fabrica.FabricaCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.servicio.ServicioCrearCredito;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCredito implements ManejadorComandoRespuesta<ComandoCredito, ComandoRespuesta<Long>> {

    private final FabricaCredito fabricaCredito;
    private final ServicioCrearCredito servicioCrearCredito;

    public ManejadorCrearCredito(FabricaCredito fabricaCredito, ServicioCrearCredito servicioCrearCredito) {
        this.fabricaCredito = fabricaCredito;
        this.servicioCrearCredito = servicioCrearCredito;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCredito comando) {
        Credito credito = this.fabricaCredito.crear(comando);
        return new ComandoRespuesta<>(servicioCrearCredito.ejecutar(credito));
    }
}
