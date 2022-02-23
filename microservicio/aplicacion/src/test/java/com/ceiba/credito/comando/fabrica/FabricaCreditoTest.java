package com.ceiba.credito.comando.fabrica;

import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.modelo.entidad.Credito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ceiba.credito.comando.ComandoCreditoTestDataBuilder.aComandoCredito;

class FabricaCreditoTest {

    private FabricaCredito fabricaCredito;

    @BeforeEach
    void inicializaR() {
        fabricaCredito = new FabricaCredito();
    }

    @Test
    @DisplayName("Debería crear un objeto de credito a partir de un comando")
    void deberiaCrearObjetoCreditoDesdeObjetoComando() {
        ComandoCredito comandoCredito = aComandoCredito().conNumeroIdentificacion("02012").build();
        Credito credito = fabricaCredito.crear(comandoCredito);
        Assertions.assertEquals(comandoCredito.getNumeroIdentificacion(),credito.getIdentificacion().getNumeroIdentificacion());
        Assertions.assertEquals(comandoCredito.getTipoIdentificacion(),credito.getIdentificacion().getTipoIdentificacion());
        Assertions.assertEquals(comandoCredito.getEgresoMensual(),credito.getEgresoMensual().getValor());
        Assertions.assertEquals(comandoCredito.getIngresoMensual(),credito.getIngresoMensual().getValor());
        Assertions.assertEquals(comandoCredito.getPlazo(),credito.getPlazo());
    }

}