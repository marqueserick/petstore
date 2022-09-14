package org.marqueserick.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.model.Pet;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PetRepository implements PanacheRepositoryBase<Pet, Long> {
    public List<Pet> findByStatus(String status){
        return this.list("STATUS", status);
    }
}
