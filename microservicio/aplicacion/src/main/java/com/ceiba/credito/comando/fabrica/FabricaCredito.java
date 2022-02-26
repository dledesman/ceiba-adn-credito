package com.ceiba.credito.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import com.ceiba.credito.modelo.enumeracion.EnumPlazo;
import com.ceiba.dinero.modelo.entidad.Dinero;
import com.ceiba.dinero.modelo.enumeracion.EnumMoneda;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FabricaCredito {

    public Credito crear(ComandoCredito comandoCredito) {

        Credito credito = new Credito(new Cliente(null, EnumTipoIdentificacion.CEDULA.getTipoIdentificacion(comandoCredito.getTipoIdentificacion()), comandoCredito.getNumeroIdentificacion()),
                new Dinero(EnumMoneda.DOLAR.getMoneda(comandoCredito.getCodigoMoneda()),comandoCredito.getIngresoMensual(),comandoCredito.getTasaCambio()),
                new Dinero(EnumMoneda.DOLAR.getMoneda(comandoCredito.getCodigoMoneda()),comandoCredito.getEgresoMensual(),comandoCredito.getTasaCambio()),
                EnumPlazo.DOCE.getPlazo(comandoCredito.getPlazo()), LocalDate.now());
        credito.setId(comandoCredito.getId());
        return credito;
    }

}
