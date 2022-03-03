package com.ceiba.credito.controlador;

import com.ceiba.credito.consulta.ManejadorListarCreditos;
import com.ceiba.credito.modelo.dto.DtoCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creditos")
@Api(tags = "Controlador consulta credito")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaControladorCredito {

    private final ManejadorListarCreditos manejadorListarCreditos;

    public ConsultaControladorCredito(ManejadorListarCreditos manejadorListarCreditos) {
        this.manejadorListarCreditos = manejadorListarCreditos;
    }

    @GetMapping
    @ApiOperation("Listar creditos")
    public List<DtoCredito> listar() {
        return this.manejadorListarCreditos.ejecutar();
    }
}
