package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.DtoCliente;
import com.ceiba.cliente.servicio.ServicioConsultarCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<DtoCliente>> {

    private final ServicioConsultarCliente servicioConsultarCliente ;

    public ManejadorConsultaCliente(ServicioConsultarCliente servicioConsultarCliente) {
        this.servicioConsultarCliente = servicioConsultarCliente;
    }

    @Override
    public ComandoRespuesta<DtoCliente> ejecutar(ComandoCliente comandoCliente) {
        return new ComandoRespuesta<>(servicioConsultarCliente.ejecutar(
                comandoCliente.getTipoIdentificacion(), comandoCliente.getNumeroIdentificacion()));
    }
}
