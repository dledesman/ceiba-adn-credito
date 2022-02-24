package com.ceiba.configuracion;

import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.credito.servicio.ServicioActualizarCredito;
import com.ceiba.credito.servicio.ServicioCrearCredito;
import com.ceiba.credito.servicio.ServicioEliminarCredito;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

class BeanServicioTest {

    private BeanServicio beanServicio;
    private RepositorioCredito repositorioCredito;
    private RepositorioUsuario repositorioUsuario;

    @BeforeEach
    public void inicializar() {
        repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        repositorioCredito = Mockito.mock(RepositorioCredito.class);
        beanServicio = new BeanServicio();
    }

    @Test
    @DisplayName("Debería devolver un servicio para crear usuarios")
    void deberiaDevolverUnServicioParaCrearUsuarios() {
        ServicioCrearUsuario respuesta = beanServicio.servicioCrearUsuario(repositorioUsuario);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    @DisplayName("Debería devolver un servicio para actualizar usuarios")
    void deberiaDevolverunServicioParaActualizarUsuarios() {
        ServicioActualizarUsuario respuesta =  beanServicio.servicioActualizarUsuario(repositorioUsuario);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    @DisplayName("Debería devolver un servicio para eliminar usuarios")
    void deberiaDevolverunServicioParaeliminarUsuarios() {
        ServicioEliminarUsuario respuesta =  beanServicio.servicioEliminarUsuario(repositorioUsuario);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    @DisplayName("Debería devolver un servicio para crear creditos")
    void deberiaDevolverUnServicioParaCrearCreditos() {
        ServicioCrearCredito respuesta = beanServicio.servicioCrearCredito(repositorioCredito);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    @DisplayName("Debería devolver un servicio para actualizarcreditos")
    void deberiaDevolverUnServicioParaActualizarCreditos() {
        ServicioActualizarCredito respuesta = beanServicio.servicioActualizarCredito(repositorioCredito);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    @DisplayName("Debería devolver un servicio para eliminar creditos")
    void deberiaDevolverUnServicioParaEliminarCreditos() {
        ServicioEliminarCredito respuesta = beanServicio.servicioEliminarCredito(repositorioCredito);
        Assertions.assertNotNull(respuesta);
    }
 }