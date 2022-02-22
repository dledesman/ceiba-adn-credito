package com.ceiba.credito.comando.fabrica;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.identificacion.modelo.entidad.Identificacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaCredito {

    public Credito crear(ComandoCredito comandoCredito) {
        return new Credito(new Identificacion(comandoCredito.getTipoIdentificacion(), comandoCredito.getNumeroIdentificacion()),
                new Dinero(comandoCredito.getMonedaTransaccion(),comandoCredito.getIngresoMensual(),1.00),
                new Dinero(comandoCredito.getMonedaTransaccion(),comandoCredito.getEgresoMensual(),1.00),
                comandoCredito.getPlazo());
    }
}
