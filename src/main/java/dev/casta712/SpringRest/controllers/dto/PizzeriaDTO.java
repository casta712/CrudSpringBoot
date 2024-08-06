package dev.casta712.SpringRest.controllers.dto;

import dev.casta712.SpringRest.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PizzeriaDTO {


    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}

