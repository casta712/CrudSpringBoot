package dev.casta712.SpringRest.persistence.impl;

import dev.casta712.SpringRest.entities.Pizzeria;
import dev.casta712.SpringRest.persistence.IPizzeriaDAO;
import dev.casta712.SpringRest.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PizzeriaDAOImpl implements IPizzeriaDAO {

    @Autowired
    private PizzeriaRepository pizzeriaRepository;

    @Override
    public List<Pizzeria> findAll() {
        return (List<Pizzeria>) pizzeriaRepository.findAll();
    }

    @Override
    public Optional<Pizzeria> findById(Long id) {

        return pizzeriaRepository.findById(id);
    }

    @Override
    public void save(Pizzeria pizzeria) {
        pizzeriaRepository.save(pizzeria);
    }

    @Override
    public void deleteById(Long id) {
        pizzeriaRepository.deleteById(id);
    }
}
