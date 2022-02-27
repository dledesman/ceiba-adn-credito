package com.ceiba.credito.comando.manejador;

import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.servicio.ServicioConsultarCliente;
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
    private final ServicioConsultarCliente servicioConsultarCliente;

    public ManejadorCrearCredito(FabricaCredito fabricaCredito,
                     ServicioCrearCredito servicioCrearCredito,
                     ServicioConsultarCliente servicioConsultarCliente) {
        this.fabricaCredito = fabricaCredito;
        this.servicioCrearCredito = servicioCrearCredito;
        this.servicioConsultarCliente = servicioConsultarCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCredito comando) {
        Credito credito = this.fabricaCredito.crear(comando);
        DtoCliente dtoCliente =  servicioConsultarCliente.ejecutar(comando.getTipoIdentificacion(),
            comando.getNumeroIdentificacion());
        credito.setId(dtoCliente.getId());
        return new ComandoRespuesta<>(servicioCrearCredito.ejecutar(credito));
    }
}
