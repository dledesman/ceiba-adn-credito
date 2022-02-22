package com.ceiba.credito.comando.manejador;

import com.ceiba.credito.comando.fabrica.FabricaCredito;
import com.ceiba.credito.servicio.ServicioEliminarCredito;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCredito implements ManejadorComando<Long> {

    private final ServicioEliminarCredito servicioEliminarCredito;

    public ManejadorEliminarCredito(ServicioEliminarCredito servicioEliminarCredito) {
        this.servicioEliminarCredito = servicioEliminarCredito;
    }

    @Override
    public void ejecutar(Long codigo) {
        servicioEliminarCredito.ejecutar(codigo);
    }
}
