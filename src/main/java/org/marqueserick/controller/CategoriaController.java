package org.marqueserick.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.dto.CategoriaDto;
import org.marqueserick.service.CategoriaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("categorias")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CategoriaController {

    @Inject
    private CategoriaService service;

    @GET
    @Operation(summary = "categorias", description = "Retorna todas as categorias")
    public List<CategoriaDto> categorias(){
        return service.listaCategorias();
    }
}
