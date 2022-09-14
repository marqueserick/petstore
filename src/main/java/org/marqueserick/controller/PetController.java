package org.marqueserick.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import org.marqueserick.dto.PetDto;
import org.marqueserick.service.PetService;
import org.marqueserick.util.pet.PetStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("pet")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class PetController {

    @Inject
    private PetService service;

    @GET
    @Operation( summary = "listarTodos", description = "Lista todos os pets")
    public List<PetDto> listar(){
        return service.listar();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "listarPorId", description = "Listar Pet por Id")
    public PetDto listarPorId(@PathParam("id") Long id){
        return service.listarPorId(id);
    }

    @POST
    @Operation( summary = "adicionarPet", description = "Adiciona um novo pet")
    public PetDto adicionar(PetDto pet){
        return service.adicionar(pet);
    }

    @PUT
    @Operation(summary = "editarPet", description = "Editar um Pet existente")
    public PetDto editar(PetDto pet){
        return service.editar(pet);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "deletarPet", description = "Deletar um pet por Id")
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }

    @GET
    @Path("/buscarPorStatus")
    @Operation(summary = "buscarPorStatus", description = "Buscar Pet por status")
    public List<PetDto> buscarPorStatus(@QueryParam("status") PetStatus status){
        return service.buscarPorStatus(status.getStatus());
    }
}
