package com.ceiba.credito.servicio;

import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Component;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
@Component
public class ServicioCrearCredito {

    private static final String SOCIO_YA_TIEN_SOLICITUD_DE_CREDITO = "El socio ya registra en solicitu de crédito en trámite";
    private static final String OBJETO_CREDITO_NO_CREADO = "Los atributos del crédito no han sido enviados";

    private final RepositorioCredito repositorioCredito;

    public ServicioCrearCredito(RepositorioCredito repositorioCredito) {
        this.repositorioCredito = repositorioCredito;
    }

    public Long ejecutar(Credito credito) {
        validarObligatorio(credito, OBJETO_CREDITO_NO_CREADO);
        validarSolicitudEnTramite(credito);
        return repositorioCredito.crear(credito);
    }

    private void validarSolicitudEnTramite(Credito credito) {
        if (repositorioCredito.existe(credito.getIdentificacion())) {
            throw new ExcepcionDuplicidad(SOCIO_YA_TIEN_SOLICITUD_DE_CREDITO);
        }
    }
}
