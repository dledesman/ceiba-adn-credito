package com.ceiba.credito.comando.fabrica;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import org.springframework.stereotype.Component;

@Component
public class FabricaCredito {

    public Credito crear(ComandoCredito comandoCredito) {
        Credito credito = new Credito(comandoCredito.getTipoIdentificacion(), comandoCredito.getNumeroIdentificacion(),
                comandoCredito.getIngresoMensual(), comandoCredito.getEgresoMensual(),
                comandoCredito.getCodigoMoneda(), comandoCredito.getPlazo(), comandoCredito.getTasaCambio());
        credito.setId(comandoCredito.getId());
        credito.setFechaSolicitud(comandoCredito.getFechaSolicitud());
        credito.setValorPrestamo(comandoCredito.getValorPrestamo());
        credito.setValorDividendo(comandoCredito.getValorDividendo());
        credito.setFechaPrimeraCuota(comandoCredito.getFechaPrimeraCuota());
        return credito;
    }

}
