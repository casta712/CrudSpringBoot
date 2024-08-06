package dev.casta712.SpringRest.Service;

import dev.casta712.SpringRest.entities.Pizzeria;


import java.util.List;
import java.util.Optional;


public interface IPizzeriaService {

    List<Pizzeria> findAll();

    Optional<Pizzeria> findById(Long id);

    void save(Pizzeria pizzeria);

    void deleteById(Long id);
}
