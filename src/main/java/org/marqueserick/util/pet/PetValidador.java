package org.marqueserick.util.pet;

import org.marqueserick.model.Pet;
import org.marqueserick.repository.PetRepository;

import java.util.Optional;

import static org.marqueserick.util.pet.PetUtils.setPendente;

public class PetValidador {

    public static boolean isPetDisponivel(Long id){
        PetRepository repository = new PetRepository();
        Optional<Pet> pet = repository.findByIdOptional(id);
        if(pet.isPresent()) {
            boolean disponivel = pet.get().getStatus().equals(PetStatus.DISPONIVEL);
            if (disponivel) setPendente(id);
            return disponivel;
        }
        throw new RuntimeException("Pet não encontrado");
    }
}
