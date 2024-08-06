package dev.casta712.SpringRest.persistence;

import dev.casta712.SpringRest.entities.Product;



import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {


    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findProductByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice);

    void save(Product product);

    void deleteById(Long id);
}
