package com.ceiba.credito.servicio;

import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.springframework.stereotype.Component;

@Component
public class ServicioEliminarCredito {

    private static final String SOLICITUD_NO_REGISTRADA = "La solicitud de crédito no se encuentra registrada";

    private final RepositorioCredito repositorioCredito;

    public ServicioEliminarCredito(RepositorioCredito repositorioCredito) {
        this.repositorioCredito = repositorioCredito;
    }

    public void ejecutar(Long codigo) {
        verificarSolicitudexistente(codigo);
        this.repositorioCredito.eliminar(codigo);
    }

    private void verificarSolicitudexistente(Long codigo) {
        if(!repositorioCredito.existePorId(codigo)) {
            throw new ExcepcionSinDatos(SOLICITUD_NO_REGISTRADA);
        }
    }
}
