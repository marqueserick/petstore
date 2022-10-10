package org.marqueserick.factory;

import org.marqueserick.dto.CategoriaDto;
import org.marqueserick.model.Categoria;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CategoriaFactory {

    public Categoria toCategoria(CategoriaDto categoriaDto){
        return Categoria.builder()
                .id(categoriaDto.getId())
                .nome(categoriaDto.getNome())
                .build();
    }

    public CategoriaDto tocategoriaDto(Categoria categoria){
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    public List<CategoriaDto> toCategoriaDtoList(List<Categoria> categorias) {
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        categorias.forEach(categoria -> categoriasDto.add(tocategoriaDto(categoria)));
        return categoriasDto;
    }
}
