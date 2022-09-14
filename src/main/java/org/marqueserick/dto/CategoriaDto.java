package org.marqueserick.dto;

import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    @JsonbProperty("categoriaId")
    private Long id;
    private String nome;

}
