package dev.casta712.SpringRest.controllers.dto;

import dev.casta712.SpringRest.entities.Pizzeria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Pizzeria pizzeria;

}
