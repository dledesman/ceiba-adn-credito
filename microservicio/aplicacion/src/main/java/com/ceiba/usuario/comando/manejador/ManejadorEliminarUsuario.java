package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarUsuario implements ManejadorComando<Long> {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    @Override
    public void ejecutar(Long idUsuario) {
        this.servicioEliminarUsuario.ejecutar(idUsuario);
    }
}
