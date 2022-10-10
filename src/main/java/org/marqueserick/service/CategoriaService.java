package org.marqueserick.service;

import org.marqueserick.dto.CategoriaDto;
import org.marqueserick.factory.CategoriaFactory;
import org.marqueserick.model.Categoria;
import org.marqueserick.repository.CategoriaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CategoriaService {

    @Inject
    private CategoriaRepository repository;

    @Inject
    private CategoriaFactory factory;
    public List<CategoriaDto> listaCategorias() {
        List<Categoria> categorias = repository.findAll().list();
        return factory.toCategoriaDtoList(categorias);
    }
}
