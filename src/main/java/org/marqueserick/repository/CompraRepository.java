package org.marqueserick.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.model.Compra;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraRepository implements PanacheRepositoryBase<Compra, Long> {
}
