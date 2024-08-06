package dev.casta712.SpringRest.repository;

import dev.casta712.SpringRest.entities.Pizzeria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaRepository extends CrudRepository<Pizzeria, Long> {
}
