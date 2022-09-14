package org.marqueserick.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.dto.CompraDto;
import org.marqueserick.service.CompraService;

import javax.inject.Inject;
import javax.ws.rs.*;

import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("loja")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CompraController {

    @Inject
    private CompraService service;

    @GET
    @Path("/compras")
    @Operation(summary = "listarTodas", description = "Listar todas as compras")
    public List<CompraDto> listarTodas(){
        return service.listarTodas();
    }

    @GET
    @Path("/compras/{id}")
    @Operation(summary = "listarPorId", description = "Listar compra por Id")
    public CompraDto listarPorId(@PathParam("id") Long id){
        return service.listarPorId(id);
    }

    @POST
    @Path("/compras")
    @Operation(summary="adicionarCompra", description = "Adicionar uma nova compra")
    public CompraDto adicionar(CompraDto compra){
        return service.adicionar(compra);
    }

    @GET
    @Path("/inventario")
    public Map<String, Integer> retornaInventario(){
        return null;
    }
}
