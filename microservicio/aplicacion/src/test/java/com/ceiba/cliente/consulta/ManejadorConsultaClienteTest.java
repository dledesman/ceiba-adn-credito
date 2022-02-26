package com.ceiba.cliente.consulta;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumTipoIdentificacion;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static com.ceiba.cliente.comando.manejador.ComandoClienteTestDataBuilder.aComandoCliente;
import static com.ceiba.cliente.consulta.DtoClienteTestDataBuilder.aDtoCliente;

class ManejadorConsultaClienteTest {

    private DaoCliente daoCliente;
    private ManejadorConsultaCliente manejadorConsultaCliente;

    @BeforeEach
    void inicializar() {
        daoCliente = Mockito.mock(DaoCliente.class);
        manejadorConsultaCliente = new ManejadorConsultaCliente(daoCliente);
    }

    @Test
    @DisplayName("Deberia consultar los datos de un cliente")
    void deberiaRetornarDatosDeCliente() {
        ComandoCliente comandoCliente = aComandoCliente().build();
        DtoCliente clienteEsperado = aDtoCliente().conId(15L)
                .conTipoIdentificacion(EnumTipoIdentificacion.CEDULA.getTipoIdentificacion("C"))
                .conNumeroIdentificacion("0201516").build();
        Mockito.when(daoCliente.consultar(Mockito.anyString(),Mockito.anyString())).thenReturn(clienteEsperado);
        DtoCliente clienteRespuesta =  manejadorConsultaCliente.ejecutar(comandoCliente);
        Assertions.assertEquals(clienteEsperado.getId(),clienteRespuesta.getId());
        Assertions.assertEquals(clienteEsperado.getTipoIdentificacion(),clienteRespuesta.getTipoIdentificacion());
        Assertions.assertEquals(clienteEsperado.getNumeroIdentificacion(),clienteRespuesta.getNumeroIdentificacion());
    }
}