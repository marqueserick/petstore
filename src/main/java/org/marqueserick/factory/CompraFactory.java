package org.marqueserick.factory;

import org.marqueserick.dto.CompraDto;
import org.marqueserick.model.Compra;
import org.marqueserick.model.Pet;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static org.marqueserick.util.pet.PetUtils.converter;


@Singleton
public class CompraFactory {
    public CompraDto toDto(Compra compra){
        Pet pet = compra.getPet();
        return CompraDto.builder()
                .id(compra.getId())
                .petDto(converter(compra.getPet()))
                .dataCompra(compra.getDataCompra())
                .status(compra.getStatus())
                .finalizada(compra.isFinalizada())
                .quantidade(compra.getQuantidade())
                .build();
    }

    public Compra toCompra(CompraDto compraDto){
        return Compra.builder()
                .pet(converter(compraDto.getPetDto()))
                .quantidade(compraDto.getQuantidade())
                .build();
    }
    public List<CompraDto> listartodosDto(List<Compra> compras) {
        List<CompraDto> comprasDto = new ArrayList<>();
        compras.forEach(compra -> comprasDto.add(toDto(compra)));
        return comprasDto;
    }
}
