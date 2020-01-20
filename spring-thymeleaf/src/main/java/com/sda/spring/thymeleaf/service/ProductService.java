package com.sda.spring.thymeleaf.service;

import com.sda.spring.thymeleaf.model.Product;
import com.sda.spring.thymeleaf.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        log.info("finding all products");
        return productRepository.findAll();
    }

    @Transactional
    public void save(Product product) {
        log.info("saving product: {}", product);
        productRepository.save(product);
    }

    public Product findById(long id) {
        log.info("finding product by id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
    }

    public void delete(long id) {
        log.info("deleting product by id: {}", id);
        productRepository.deleteById(id);
    }
}
