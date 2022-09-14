package org.marqueserick.dto;
import lombok.*;
import org.marqueserick.util.pet.PetStatus;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    @JsonbProperty("petId")
    private Long id;
    private String nome;
    private PetStatus status;
    @JsonbProperty("categoria")
    private CategoriaDto categoriaDto;

    public String getStatus(){
        return this.status.getStatus();
    }
}
