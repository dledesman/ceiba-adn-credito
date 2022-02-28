package com.ceiba.credito.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.credito.comando.ComandoCredito;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static  com.ceiba.servicio.testdatabuilder.ComandoCreditoTestDataBuilder.aComandoCredito;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCredito.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorCreditoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Debería crear un crédito")
    void deberiaCrearUnCredito() throws Exception {
        ComandoCredito comandoCredito = aComandoCredito().conNumeroIdentificacion("02017333").build();
        mockMvc.perform(post("/creditos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCredito)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 5}"));
    }

    @Test
    @DisplayName("Debería actualizar un crédito")
    void deberiaActulizarUnCredito() throws Exception {
        Long id = 4L;
        ComandoCredito comandoCredito = aComandoCredito().build();
        mockMvc.perform(MockMvcRequestBuilders.put("/creditos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCredito)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería eliminar un crédito")
    void deberiaEliminarUnCredito() throws Exception {
        Long id = 3L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/creditos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/creditos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

}