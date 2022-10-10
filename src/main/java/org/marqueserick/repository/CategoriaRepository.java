package org.marqueserick.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.model.Categoria;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Long> {
}
