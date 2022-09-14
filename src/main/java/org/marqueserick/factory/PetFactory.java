package org.marqueserick.factory;

import org.marqueserick.dto.CategoriaDto;
import org.marqueserick.dto.PetDto;
import org.marqueserick.model.Categoria;
import org.marqueserick.model.Pet;
import org.marqueserick.util.pet.PetStatus;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static org.marqueserick.util.categoria.CategoriaUtils.converter;

@Singleton
public class PetFactory {

    public PetDto toDto(Pet pet){
        return PetDto.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .status(pet.getStatus())
                .categoriaDto(converter(pet.getCategoria()))
                .build();
    }
    public Pet toPet(PetDto petDto) {
        return Pet.builder()
                .nome(petDto.getNome())
                .status(PetStatus.valueOf(petDto.getStatus()))
                .categoria(converter(petDto.getCategoriaDto()))
                .build();
    }

    public List<PetDto> listarTodosDto(List<Pet> pets){
        List<PetDto> petsDto = new ArrayList<>();
        for (Pet pet : pets) {
            petsDto.add(toDto(pet));
        }
        return petsDto;
    }
}
