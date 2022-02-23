package com.ceiba.credito.comando.manejador;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.comando.fabrica.FabricaCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.servicio.ServicioActualizarCredito;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCredito implements ManejadorComando<ComandoCredito> {


    private final FabricaCredito fabricaCredito;

    private final ServicioActualizarCredito servicioActualizarCredito;

    public ManejadorActualizarCredito(FabricaCredito fabricaCredito, ServicioActualizarCredito servicioActualizarCredito) {
        this.fabricaCredito = fabricaCredito;
        this.servicioActualizarCredito = servicioActualizarCredito;
    }

    @Override
    public void ejecutar(ComandoCredito comando) {
        Credito credito = this.fabricaCredito.crear(comando);
        servicioActualizarCredito.ejecutar(credito);
    }
}
