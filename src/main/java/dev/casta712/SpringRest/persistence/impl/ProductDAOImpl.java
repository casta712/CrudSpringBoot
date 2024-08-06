package dev.casta712.SpringRest.persistence.impl;

import dev.casta712.SpringRest.entities.Product;
import dev.casta712.SpringRest.persistence.IProductDAO;
import dev.casta712.SpringRest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {

        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findProductByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice) {
        return productRepository.findProductByPriceInRange(mixPrice, maxPrice);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
