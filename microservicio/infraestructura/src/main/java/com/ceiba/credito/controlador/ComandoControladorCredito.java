package com.ceiba.credito.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.credito.comando.ComandoCredito;
import com.ceiba.credito.comando.manejador.ManejadorActualizarCredito;
import com.ceiba.credito.comando.manejador.ManejadorCrearCredito;
import com.ceiba.credito.comando.manejador.ManejadorEliminarCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditos")
@Api(tags = {"Controlador comando credito"})
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorCredito {

    private final ManejadorCrearCredito manejadorCrearCredito;
    private final ManejadorActualizarCredito manejadorActualizarCredito;
    private final ManejadorEliminarCredito manejadorEliminarCredito;

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
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCredito comandoCredito) {
        return manejadorCrearCredito.ejecutar(comandoCredito);
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
