package com.ceiba.credito.consulta;

import com.ceiba.credito.modelo.dto.DtoCredito;
import com.ceiba.credito.puerto.dao.DaoCredito;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static com.ceiba.credito.consulta.DtoCreditoTestDataBuilder.aDtoCredito;


class ManejadorListarCreditosTest {

    private DaoCredito daoCredito;
    private ManejadorListarCreditos manejadorListarCreditos;

    @BeforeEach
    void inicializar() {
        daoCredito = Mockito.mock(DaoCredito.class);
        manejadorListarCreditos = new ManejadorListarCreditos(daoCredito);
    }

    @Test
    @DisplayName("Debería retorar una lista de solicitudes de crédito")
    void deberiaRetornarUnaListaDeSolictudesDeCredito() {
        List<DtoCredito> listaSolicitudes = new ArrayList<>();
        listaSolicitudes.add(aDtoCredito().conNumeroIdentificacion("02013").build());
        listaSolicitudes.add(aDtoCredito().conNumeroIdentificacion("02014").build());
        listaSolicitudes.add(aDtoCredito().conNumeroIdentificacion("02015").build());
        Mockito.when(daoCredito.listar()).thenReturn(listaSolicitudes);
        manejadorListarCreditos.ejecutar();
        Assertions.assertEquals(3, listaSolicitudes.size());
    }
}