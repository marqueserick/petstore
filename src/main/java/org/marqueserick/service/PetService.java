package org.marqueserick.service;

import org.marqueserick.dto.PetDto;
import org.marqueserick.factory.PetFactory;
import org.marqueserick.model.Pet;
import org.marqueserick.repository.PetRepository;
import org.marqueserick.util.pet.PetStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class PetService {

    @Inject
    private PetRepository repository;

    @Inject
    private PetFactory petFactory;


    public List<PetDto> listar() {
        return petFactory.listarTodosDto(repository.listAll());
    }

    public PetDto listarPorId(Long id) {
        Pet pet = buscarPorId(id, "Pet não encontrado");
        return petFactory.toDto(pet);
    }

    public PetDto adicionar(PetDto petDto) {
        Pet pet = petFactory.toPet(petDto);
        repository.persist(pet);
        return petFactory.toDto(pet);
    }

    public PetDto editar(PetDto petDto) {
        Pet pet = buscarPorId(petDto.getId(),"Pet não encontrado com ID fornecido");
        repository.persist(editarPet(pet, petDto));
        return petFactory.toDto(pet);
    }

    private Pet editarPet(Pet pet, PetDto petDto) {
        pet.setNome(petDto.getNome());
        pet.setStatus(PetStatus.valueOf(petDto.getStatus()));
        return pet;
    }

    public void deletar(Long id) {
        Pet pet = buscarPorId(id, "Pet não encontrado");
        repository.deleteById(id);
    }

    public List<PetDto> buscarPorStatus(String status) {
        return petFactory.listarTodosDto(repository.findByStatus(status));
    }

    private Pet buscarPorId(Long id, String mensagem){
        Optional<Pet> pet = repository.findByIdOptional(id);
        if(pet.isEmpty()) throw new RuntimeException(mensagem);
        return pet.get();
    }


}
