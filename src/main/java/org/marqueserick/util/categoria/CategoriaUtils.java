package org.marqueserick.util.categoria;

import org.marqueserick.dto.CategoriaDto;
import org.marqueserick.model.Categoria;

public class CategoriaUtils {

    public static CategoriaDto converter(Categoria categoria){
       return CategoriaDto.builder()
               .id(categoria.getId())
               .nome(categoria.getNome())
               .build();
    }

    public static Categoria converter(CategoriaDto categoriaDto){
        return Categoria.builder()
                .id(categoriaDto.getId())
                .nome(categoriaDto.getNome())
                .build();
    }
}
