package dev.casta712.SpringRest.controllers;

import dev.casta712.SpringRest.Service.IPizzeriaService;
import dev.casta712.SpringRest.controllers.dto.PizzeriaDTO;
import dev.casta712.SpringRest.entities.Pizzeria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    @Autowired
    private IPizzeriaService pizzeriaService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Pizzeria> pizzeriaOptional = pizzeriaService.findById(id);

        if(pizzeriaOptional.isPresent()) {
            Pizzeria pizzeria = pizzeriaOptional.get();

            PizzeriaDTO pizzeriaDTO = PizzeriaDTO.builder()
                    .id(pizzeria.getId())
                    .name(pizzeria.getName())
                    .productList(pizzeria.getProductList())
                    .build();
            return ResponseEntity.ok(pizzeriaDTO);
        }

        return ResponseEntity.notFound().build();

    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<PizzeriaDTO> pizzeriaList = pizzeriaService.findAll()
                .stream()
                .map(pizzeria -> PizzeriaDTO.builder()
                        .id(pizzeria.getId())
                        .name(pizzeria.getName())
                        .productList(pizzeria.getProductList())
                        .build())
                        .toList();
                return ResponseEntity.ok(pizzeriaList);

    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PizzeriaDTO pizzeriaDTO) throws URISyntaxException {

        if(pizzeriaDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        pizzeriaService.save(Pizzeria.builder()
                .name(pizzeriaDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/pizzeria/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePizzeria(@PathVariable Long id, @RequestBody PizzeriaDTO pizzeriaDTO) {

        Optional<Pizzeria> pizzeriaOptional = pizzeriaService.findById(id);

        if(pizzeriaOptional.isPresent()) {
            Pizzeria pizzeria = pizzeriaOptional.get();
            pizzeria.setName(pizzeriaDTO.getName());
            pizzeriaService.save(pizzeria);
            return ResponseEntity.ok("Dato Actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if(id != null) {
            pizzeriaService.deleteById(id);
            return ResponseEntity.ok("Dato Eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}

