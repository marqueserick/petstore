package org.marqueserick.util.pet;

import org.marqueserick.dto.PetDto;
import org.marqueserick.model.Pet;
import org.marqueserick.repository.PetRepository;

import java.util.HashMap;
import java.util.Map;

public class PetUtils {

    public static PetDto converter(Pet pet){
        return PetDto.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .status(pet.getStatus())
                .build();
    }

    public static Pet converter(PetDto petDto){
        return Pet.builder()
                .id(petDto.getId())
                .nome(petDto.getNome())
                .status(PetStatus.valueOf(petDto.getStatus()))
                .build();
    }

    public static Map<String,Long> retornaInventario(){
        PetRepository repository = new PetRepository();
        Map<String, Long> inventario = new HashMap<>();
        for(PetStatus status: PetStatus.values()){
            Long quantidade = repository.getQuantidadePorStatus(status.getStatus());
            inventario.put(status.getStatus(),quantidade);
        }

        return inventario;
    }

    public static void setPendente(Long id){
        PetRepository repository = new PetRepository();
        Pet pet = repository.findById(id);
        pet.setStatus(PetStatus.PENDENTE);
        repository.persist(pet);

    }
}
