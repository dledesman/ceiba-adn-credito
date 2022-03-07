package com.ceiba.credito.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.comando.manejador.ManejadorActualizarCredito;
import com.ceiba.credito.comando.manejador.ManejadorCrearCredito;
import com.ceiba.credito.comando.manejador.ManejadorEliminarCredito;
import com.ceiba.credito.modelo.dto.DtoMensajeRespuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

@RestController
@RequestMapping("/creditos")
@Api(tags = {"Controlador comando credito"})
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorCredito {

    private final ManejadorCrearCredito manejadorCrearCredito;
    private final ManejadorActualizarCredito manejadorActualizarCredito;
    private final ManejadorEliminarCredito manejadorEliminarCredito;
    private static final Logger LOG = LoggerFactory.getLogger(ComandoControladorCredito.class);

    @Autowired
    public ComandoControladorCredito(ManejadorCrearCredito manejadorCrearCredito,
            ManejadorActualizarCredito manejadorActualizarCredito,
            ManejadorEliminarCredito manejadorEliminarCredito) {
        this.manejadorCrearCredito = manejadorCrearCredito;
        this.manejadorActualizarCredito = manejadorActualizarCredito;
        this.manejadorEliminarCredito = manejadorEliminarCredito;
    }

    @PostMapping
    @ApiOperation("Crear crédito")
    public ResponseEntity<Object> crear(@RequestBody ComandoCredito comandoCredito) {
        DtoMensajeRespuesta dtoRespuesta;
        try {
            ComandoRespuesta<Long> respuesta = manejadorCrearCredito.ejecutar(comandoCredito);
            dtoRespuesta = new DtoMensajeRespuesta(respuesta.getValor().toString(),"registro exitoso");
            return ResponseEntity.ok(dtoRespuesta);
        } catch (ExcepcionValorInvalido | ExcepcionDuplicidad ex ) {
            dtoRespuesta = new DtoMensajeRespuesta("000",ex.getMessage());
            LOG.info(ex.getMessage(), ex);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dtoRespuesta);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar crédito")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCredito.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar credito")
    public void actualizar(@RequestBody ComandoCredito comandoCredito, @PathVariable Long id) {
        comandoCredito.setId(id);
        manejadorActualizarCredito.ejecutar(comandoCredito);
    }
}
