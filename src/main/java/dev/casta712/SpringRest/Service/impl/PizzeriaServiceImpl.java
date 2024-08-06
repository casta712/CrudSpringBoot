package dev.casta712.SpringRest.Service.impl;

import dev.casta712.SpringRest.Service.IPizzeriaService;
import dev.casta712.SpringRest.entities.Pizzeria;
import dev.casta712.SpringRest.persistence.IPizzeriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaServiceImpl implements IPizzeriaService {

    @Autowired
    private IPizzeriaDAO pizzeriaDAO;

    @Override
    public List<Pizzeria> findAll() {
        return pizzeriaDAO.findAll();
    }

    @Override
    public Optional<Pizzeria> findById(Long id) {
        return pizzeriaDAO.findById(id);
    }

    @Override
    public void save(Pizzeria pizzeria) {
        pizzeriaDAO.save(pizzeria);
    }

    @Override
    public void deleteById(Long id) {
        pizzeriaDAO.deleteById(id);
    }
}
