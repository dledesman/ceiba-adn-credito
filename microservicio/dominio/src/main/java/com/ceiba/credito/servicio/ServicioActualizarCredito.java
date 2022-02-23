package com.ceiba.credito.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioActualizarCredito {

    private static final String SOLICITUD_NO_REGISTRADA = "La solicitud de crédito no se encuentra registrada";
    private static final String OBJETO_CREDITO_NO_CREADO = "Los atributos del crédito no han sido enviados";

    private final RepositorioCredito repositorioCredito;

    public ServicioActualizarCredito(RepositorioCredito repositorioCredito) {
        this.repositorioCredito = repositorioCredito;
    }

    public void ejecutar(Credito credito) {
        validarObligatorio(credito, OBJETO_CREDITO_NO_CREADO);
        verificarSolicitudexistente(credito.getCodigo());
        this.repositorioCredito.actualizar(credito);
    }

    private void verificarSolicitudexistente(Long codigo) {
        if(!repositorioCredito.existePorId(codigo)) {
            throw new ExcepcionSinDatos(SOLICITUD_NO_REGISTRADA);
        }
    }

}
