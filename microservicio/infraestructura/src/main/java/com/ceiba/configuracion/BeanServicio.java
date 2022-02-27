package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioConsultarCliente;
import com.ceiba.credito.puerto.repositorio.RepositorioCredito;
import com.ceiba.credito.servicio.ServicioActualizarCredito;
import com.ceiba.credito.servicio.ServicioCrearCredito;
import com.ceiba.credito.servicio.ServicioEliminarCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    RepositorioCredito repositorioCredito;
    RepositorioUsuario repositorioUsuario;

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCredito servicioCrearCredito(RepositorioCredito repositorioCredito, RepositorioCliente repositorioCliente) {
        return new ServicioCrearCredito(repositorioCredito);
    }

    @Bean
    public ServicioActualizarCredito servicioActualizarCredito(RepositorioCredito repositorioCredito) {
        return  new ServicioActualizarCredito(repositorioCredito);
    }

    @Bean
    public ServicioEliminarCredito servicioEliminarCredito(RepositorioCredito repositorioCredito) {
        return new ServicioEliminarCredito(repositorioCredito);
    }

    @Bean
    public ServicioConsultarCliente servicioConsultarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioConsultarCliente(repositorioCliente);
    }
}
